package jm.task.core.jdbc.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    static String host = "localhost";
    static int port = 3306;
    static String dbname = "test_db";
    static String user = "root";
    static String pwd = "12345";

    public static Connection connect() {
        String url = String.format("jdbc:mysql://%s:%d/%s", host, port, dbname);
        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}