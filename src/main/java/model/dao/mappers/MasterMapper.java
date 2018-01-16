package model.dao.mappers;

import dto.Level;
import dto.Master;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterMapper {
    private static final Logger LOGGER = LogManager.getLogger(MasterMapper.class);

    public static Master map(ResultSet resultSet) {
        Master master = new Master();
        try {
            master.setMasterId(resultSet.getLong("idmaster"));
            master.setFirstName(resultSet.getString("first_name"));
            master.setLastName(resultSet.getString("last_name"));
            master.setEmail(resultSet.getString("e_mail"));
            master.setPassword(resultSet.getString("password"));
            master.setPhoneNumber(resultSet.getString("phone_number"));
            master.setLevel(Level.getLevel(resultSet.getString("level")));

        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return master;
    }
}
