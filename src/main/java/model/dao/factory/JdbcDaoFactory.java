package model.dao.factory;

import model.dao.daoImpl.ImageJdbcDao;
import model.dao.daoImpl.MasterJdbcDao;
import model.dao.daoImpl.RecordJdbcDao;
import model.dao.daoImpl.UserJdbcDao;
import model.dao.daoInterfaces.ImageDao;
import model.dao.daoInterfaces.MasterDao;
import model.dao.daoInterfaces.RecordDao;
import model.dao.daoInterfaces.UserDao;

public class JdbcDaoFactory implements DaoFactory {
    private static JdbcDaoFactory jdbcDaoFactory = new JdbcDaoFactory();
    private UserJdbcDao userJdbcDao = new UserJdbcDao();
    private MasterJdbcDao masterJdbcDao = new MasterJdbcDao();
    private RecordJdbcDao recordJdbcDao = new RecordJdbcDao();
    private ImageJdbcDao imageJdbcDao = new ImageJdbcDao();

    @Override
    public UserDao getUserDao() {
        return userJdbcDao;
    }

    @Override
    public MasterDao getMasterDao() {
        return masterJdbcDao;
    }

    @Override
    public RecordDao getRecordDao() {
        return recordJdbcDao;
    }

    @Override
    public ImageDao getImageDao() {
        return imageJdbcDao;
    }

    public static JdbcDaoFactory getInstance() {
        return jdbcDaoFactory;
    }
}
