import model.dao.daoImpl.UserJdbcDao;
import model.dao.jdbc.ConnectionManager;

public class Main {
    public static void main(String[] args) {
        ConnectionManager.initFromJNDI("jdbc/beauty_saloon");
        UserJdbcDao userJdbcDao = new UserJdbcDao();
        System.out.println(userJdbcDao.findAll());


    }
}
