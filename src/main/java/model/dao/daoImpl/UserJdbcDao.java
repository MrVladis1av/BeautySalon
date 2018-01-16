package model.dao.daoImpl;

import dto.User;
import model.dao.daoImpl.template.JdbcHelper;
import model.dao.daoInterfaces.UserDao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.UserMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao {
    ConnectionManager cm;
    JdbcHelper helper;

    public UserJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        helper = new JdbcHelper(cm);
    }


    @Override
    public User read(String userName) {

        return null;
    }

    @Override
    public Long add(User user) {
        return helper.insert("INSERT INTO user " +
                        "(first_name," +
                        "last_name," +
                        "e_mail," +
                        "password)" +
                        "VALUES(?,?,?,?)",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());
    }

    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT iduser,first_name,last_name, e_mail, password, role.role " +
                "FROM beauty_saloon.user " +
                "JOIN beauty_saloon.role " +
                "ON user.role = role.idrole;";
        List<User> list = new ArrayList<User>();
        try (PreparedStatement stm = cm.getConnection().prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(UserMapper.map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
