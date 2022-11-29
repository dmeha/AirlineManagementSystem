package Transactions.Model;

import java.sql.*;

public class DAO {
    String url;
    String user;
    String password;
    Connection connection=null;
    public DAO(){
        this.url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_TEST";
        this.user = "CSCI5308_12_TEST_USER";
        this.password = "EJaiqueigahNg6cu";

    }

    public Connection getConnection(){
        try {

            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        }catch (Exception e){
            System.out.println("Cannot connect to DB");
        }
        return this.connection;
    }

    public void closeConnection(){
        try{
            this.connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

