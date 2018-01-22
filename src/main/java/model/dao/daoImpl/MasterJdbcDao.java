package model.dao.daoImpl;

import dto.Master;
import dto.Role;
import dto.User;
import model.dao.daoImpl.template.JdbcHelper;
import model.dao.daoInterfaces.MasterDao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.MasterMapper;
import model.dao.mappers.UserMapper;

import java.sql.*;
import java.util.List;

public class MasterJdbcDao implements MasterDao {
    ConnectionManager cm;
    JdbcHelper helper;

    public MasterJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        helper = new JdbcHelper(cm);
    }

    @Override
    public Long add(Master master) {
        String userQuery = "INSERT INTO user " +
                "(first_name," +
                "last_name," +
                "e_mail," +
                "password," +
                "role)" +
                "VALUES(?,?,?,?,?)";
        String masterQuery = "INSERT INTO master " +
                "(level," +
                "phone_number," +
                "description," +
                "iduser)" +
                "VALUES(?,?,?,?)";
        Connection connection = cm.getConnection();
        PreparedStatement userStatement = null;
        PreparedStatement masterStatement = null;
        try {
            connection.setAutoCommit(false);

            userStatement = connection.prepareStatement(userQuery, Statement.RETURN_GENERATED_KEYS);
            masterStatement = connection.prepareStatement(masterQuery);
            userStatement.setString(1, master.getFirstName());
            userStatement.setString(2, master.getLastName());
            userStatement.setString(3, master.getEmail());
            userStatement.setString(4, master.getPassword());
            userStatement.setLong(5, findRoleId(Role.MASTER));
            userStatement.executeUpdate();
            ResultSet rs = userStatement.getGeneratedKeys();
            rs.next();
            masterStatement.setString(1, master.getLevel().toString());
            masterStatement.setString(2, master.getPhoneNumber());
            masterStatement.setString(3, master.getDescription());
            masterStatement.setLong(4, rs.getLong(1));
            masterStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (userStatement != null) {
                    userStatement.close();
                }
                if (masterStatement != null) {
                    masterStatement.close();
                }
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 1L;
    }

    @Override
    public Master findByEmail(String email) {
        Master master = helper.findObject("SELECT * FROM user JOIN master on user.iduser=master.iduser " +
                "WHERE e_mail=?", MasterMapper::map, email);
        return master;
    }

    @Override
    public Master find(Long id) {
        return null;
    }

    @Override
    public void update(Master master) {
        helper.update("UPDATE master " +
                        "SET " +
                        "level=?, " +
                        "phone_number=?, " +
                        "description=? " +
                        "WHERE idmaster=?",
                master.getLevel().toString(),
                master.getPhoneNumber(),
                master.getDescription(),
                master.getMasterId());
    }

    @Override
    public void updateDescription(String description) {
        Connection connection = cm.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE master SET description =?");
            preparedStatement.setString(1, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Master> findAll() {
        List<Master> list = helper.findAll("SELECT * FROM user JOIN master ON user.iduser=master.iduser", MasterMapper::map);
        return list;
    }

    @Override
    public Long findRoleId(Role role) {
        return helper.findObject("SELECT idrole FROM role " +
                "WHERE role=?", rs -> {
            try {
                return rs.getLong("idrole");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }, role.toString());
    }
}
