package model.dao.mappers;

import dto.Image;
import dto.Level;
import dto.Master;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper {
    private static final Logger LOGGER = LogManager.getLogger(ImageMapper.class);

    public static Image map(ResultSet resultSet) {
        Image image = new Image();
        try {
            image.setImageId(resultSet.getLong("idimage"));
            Master master = new Master();
            master.setMasterId(resultSet.getLong("idmaster"));
            image.setMaster(master);
            image.setURL(resultSet.getString("path"));

        } catch (SQLException e) {
            LOGGER.error("can't map object", e);
        }
        return image;
    }
}
