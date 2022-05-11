package jm.task.core.jdbc.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Connection connect() {

        String host = "localhost";
        int port = 3306;
        String dbname = "test_db";
        String user = "root";
        String pwd = "12345";

        String url = String.format("jdbc:mysql://%s:%d/%s", host, port, dbname);
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}