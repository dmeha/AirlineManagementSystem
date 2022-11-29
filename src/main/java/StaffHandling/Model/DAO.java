package StaffHandling.Model;

import java.sql.*;

public class DAO {
    String url;
    String user;
    String password;

    public DAO() {
        this.url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_TEST";
        this.user = "CSCI5308_12_TEST_USER";
        this.password = "EJaiqueigahNg6cu";

    }

    // To make connection with database
    public Connection getConnection() {
        try {
            Connection connection;
            connection = DriverManager.getConnection(this.url, this.user, this.password);
            return connection;
        } catch (Exception e) {
            System.out.println("Cannot connect to DB");
            return null;
        }
    }

    // To close connection with database
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

