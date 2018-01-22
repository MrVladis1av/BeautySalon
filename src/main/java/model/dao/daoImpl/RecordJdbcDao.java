package model.dao.daoImpl;

import dto.Record;
import model.dao.daoImpl.template.JdbcHelper;
import model.dao.daoInterfaces.RecordDao;
import model.dao.jdbc.ConnectionManager;

import java.util.List;

public class RecordJdbcDao implements RecordDao {
    ConnectionManager cm;
    JdbcHelper helper;

    public RecordJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        helper = new JdbcHelper(cm);
    }

    @Override
    public Long add(Record record) {
        return helper.insert("INSERT INTO record " +
                        "(user_id," +
                        "master_id," +
                        "time_form," +
                        "time_to," +
                        "date)" +
                        "VALUES(?,?,?,?,?)",
                record.getUser().getUserId(),
                record.getMaster().getMasterId(),
                record.getTimeFrom(),
                record.getTimeTo(),
                record.getDate());
    }

    @Override
    public Record find(Long id) {
        return null;
    }

    @Override
    public void update(Record record) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Record> findAll() {
        return null;
    }
}
