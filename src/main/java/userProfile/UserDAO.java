package userProfile;

import java.sql.*;

public class UserDAO {
    String url;
    String user;
    String password;


    public UserDAO() {
        this.url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_TEST";
        this.user = "CSCI5308_12_TEST_USER";
        this.password = "EJaiqueigahNg6cu";

    }

    // Start Connection with Database
    public Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            System.out.println("Cannot connect to DB");
        }
        return connection;
    }

    // Close Connection with Database
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ResultSet ExecuteSelect(PreparedStatement preparedStatement){
        try {

            return preparedStatement.executeQuery();

        }catch (Exception e){
            return null;
        }

    }

    public Boolean ExecuteUpdate(PreparedStatement preparedStatement){
        try{
            preparedStatement.executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
