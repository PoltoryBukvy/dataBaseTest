package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Connection c;

    public UserDaoJDBCImpl() {
        c = Util.connect();
    }

    public void createUsersTable() {
        try {
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE USER " +
                    "(id BIGINT not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        try {
            Statement stmt = c.createStatement();
            String sql = "DROP TABLE USER";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Statement stmt = c.createStatement();
            String sql = "insert into USER (name, lastName, age)"
                    + " values ('" + name + "', '" + lastName + "', " + age +")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            Statement stmt = c.createStatement();
            String sql = "delete from USER where id = " + id;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        ArrayList<User> userArrayList = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            String sql = "select * from USER";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                User user = new User();
                user.setId(data.getLong(1));
                user.setName(data.getString(2));
                user.setLastName(data.getString(3));
                user.setAge(data.getByte(4));
                userArrayList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userArrayList;
    }

    public void cleanUsersTable() {
        try {
            Statement stmt = c.createStatement();
            String sql = "delete from USER";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
