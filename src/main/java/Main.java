import controller.util.converters.Sha256Encoder;
import dto.Level;
import dto.Master;
import dto.Record;
import dto.Role;
import model.dao.daoImpl.MasterJdbcDao;
import model.dao.daoImpl.RecordJdbcDao;
import model.dao.daoImpl.UserJdbcDao;
import model.dao.jdbc.ConnectionManager;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConnectionManager.initFromProperties();
        MasterJdbcDao dao = new MasterJdbcDao();
        List<Master> list = dao.findAll();
        System.out.println(list);
    }
}
