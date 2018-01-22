package model.dao.daoImpl;

import dto.Image;
import model.dao.daoImpl.template.JdbcHelper;
import model.dao.daoInterfaces.ImageDao;
import model.dao.jdbc.ConnectionManager;
import model.dao.mappers.ImageMapper;

import java.util.List;

public class ImageJdbcDao implements ImageDao {
    ConnectionManager cm;
    JdbcHelper helper;

    public ImageJdbcDao() {
        this.cm = ConnectionManager.getInstance();
        helper = new JdbcHelper(cm);
    }

    @Override
    public Long add(Image image) {
        return helper.insert("INSERT INTO image " +
                        "(path," +
                        "master) " +
                        "VALUES(?,?)",
                image.getURL(),
                image.getMaster().getMasterId());
    }

    @Override
    public Image find(Long id) {
        Image image = helper.findObject("SELECT * FROM image " +
                "WHERE idimage=?", ImageMapper::map, id);
        return image;
    }

    @Override
    public void update(Image image) {
        helper.update("UPDATE image " +
                        "SET " +
                        "path=?, " +
                        "master=? " +
                        "WHERE idimage=?",
                image.getURL(),
                image.getMaster().getMasterId());
    }

    @Override
    public void delete(Long id) {
        helper.remove("DELETE FROM image " +
                "WHERE idimage=?", id);
    }

    @Override
    public List<Image> findAll() {
        return helper.findAll("SELECT * FROM image", ImageMapper::map);
    }
}
