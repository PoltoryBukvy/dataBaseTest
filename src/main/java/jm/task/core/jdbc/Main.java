package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        //userDao.dropUsersTable();
        //userDao.createUsersTable();
        //userDao.createUsersTable();
        //userDao.saveUser("Toma", "Ustyan", (byte) 27);
        //userDao.saveUser("Alina", "Lisova", (byte) 26);
        //List<User> list = userDao.getAllUsers();
        //for (User user : list) {
          //  System.out.println(user);
        //}
        //userDao.removeUserById(1);
        userDao.cleanUsersTable();

    }
}
