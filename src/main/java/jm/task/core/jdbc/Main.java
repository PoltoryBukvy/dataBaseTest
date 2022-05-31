package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /* UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Yasha", "Kotik", (byte) 8);
        userDaoJDBC.saveUser("Marusya", "Kisa", (byte) 6);
        for (User user : userDaoJDBC.getAllUsers()) {
            System.out.println(user);
        }
        userDaoJDBC.removeUserById(1);
        userDaoJDBC.dropUsersTable(); */

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Yasha", "Kotik", (byte) 8);
        userDaoHibernate.saveUser("Marusya", "Kisa", (byte) 6);
        for (User user : userDaoHibernate.getAllUsers()) {
            System.out.println(user);
        }

    }
}


