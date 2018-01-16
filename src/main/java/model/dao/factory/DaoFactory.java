package model.dao.factory;

import model.dao.daoInterfaces.ImageDao;
import model.dao.daoInterfaces.MasterDao;
import model.dao.daoInterfaces.RecordDao;
import model.dao.daoInterfaces.UserDao;

public interface DaoFactory {
    UserDao getUserDao();

    MasterDao getMasterDao();

    RecordDao getRecordDao();

    ImageDao getImageDao();
}
