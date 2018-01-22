package model.dao.daoImpl;

import dto.Role;
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
        User user = helper.findObject("SELECT * FROM user " +
                "WHERE iduser=?", UserMapper::map, id);
        return user;
    }

    @Override
    public void update(User user) {
        helper.update("UPDATE user " +
                        "SET " +
                        "first_name=?, " +
                        "last_name=?, " +
                        "e_mail=?, " +
                        "password=?, " +
                        "role=? " +
                        "WHERE iduser=?",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                findRoleId(user.getRole()),
                user.getUserId());
    }

    @Override
    public void delete(Long id) {
        helper.remove("DELETE FROM user " +
                "WHERE iduser=?", id);
    }

    @Override
    public User findByEmail(String email) {
        User user = helper.findObject("SELECT * FROM user " +
                "WHERE e_mail=?", UserMapper::map, email);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = helper.findAll("SELECT * FROM user", UserMapper::map);
        return users;
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
