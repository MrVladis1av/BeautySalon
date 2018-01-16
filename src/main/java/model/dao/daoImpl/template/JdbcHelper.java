package model.dao.daoImpl.template;

import model.dao.jdbc.ConnectionManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;

public class JdbcHelper {
    private static final Logger LOGGER = LogManager.getLogger(JdbcHelper.class);

    private ConnectionManager connectionManager;

    public JdbcHelper(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Long insert(String query, Object... params) {
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        try (PreparedStatement statement
                     = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error("Can't insert into DB");
        } finally {
            closeConn(connection);
        }
        return null;
    }



    private void closeConn(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Cannot close jdbc connection", e);
        }
    }
}
