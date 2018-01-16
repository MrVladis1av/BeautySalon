package model.dao.mappers;

import dto.Master;
import dto.Record;
import dto.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordMapper {
    private static final Logger LOGGER = LogManager.getLogger(RecordMapper.class);

    public static Record map(ResultSet resultSet) {
        Record record = new Record();
        try {
            record.setRecordId(resultSet.getLong("idrecord"));
            User user = new User();
            user.setUserId(resultSet.getLong("iduser"));
            record.setUser(user);
            Master master = new Master();
            master.setMasterId(resultSet.getLong("idmaster"));
            record.setMaster(master);
            record.setDate(resultSet.getDate("date"));
            record.setTimeFrom(resultSet.getTime("time_from"));
            record.setTimeTo(resultSet.getTime("time_to"));

        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return record;
    }
}
