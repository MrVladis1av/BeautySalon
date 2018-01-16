package model.dao.daoInterfaces;

import dto.User;

public interface UserDao extends Dao<User, Long> {
    User read(String userName);
}
