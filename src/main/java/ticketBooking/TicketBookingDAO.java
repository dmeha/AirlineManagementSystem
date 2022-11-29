package ticketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketBookingDAO {
    String url;
    String user;
    String password;
    Connection connection=null;
    public TicketBookingDAO(){
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


    public void ExecuteInsert(PreparedStatement preparedStatement){
        try {
            preparedStatement.execute();
        }catch (Exception e){
            //
        }
    }



}
