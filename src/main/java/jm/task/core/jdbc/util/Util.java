package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Util instance;

    private static String host = "localhost";
    private static int port = 3306;
    private static String dbname = "test_db";
    private static String user = "root";
    private static String pwd = "12345";
    private static String url = String.format("jdbc:mysql://%s:%d/%s", host, port, dbname);

    private Util() { }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", url)
                .setProperty("hibernate.connection.username", user)
                .setProperty("hibernate.connection.password", pwd);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

}