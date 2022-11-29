package RouteFinder.dbOps;

import java.sql.*;
public class DAO {
    String url;
    String user;
    String password;
    Connection connection=null;
    public DAO(){
        this.url = "jdbc:mysql://127.0.0.1:3306/AMS_Final";
        this.user = "root";
        this.password = "password";

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
