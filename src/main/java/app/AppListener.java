package app;

import model.dao.jdbc.ConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ConnectionManager.initFromJNDI("jdbc/beauty_saloon");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
