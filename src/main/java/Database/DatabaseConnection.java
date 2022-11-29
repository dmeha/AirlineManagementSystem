package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection implements DBconnection{

    Mode mode;
    Connection DB;

    public DatabaseConnection(Mode mode) {
        this.mode = mode;
    }

    public Connection connect() {

        try {
            //set config; provided Mode of operation
            Config dbc = new Config(this.mode);
            //connection object
            this.DB = DriverManager.getConnection(dbc.getUrl(),dbc.getUser(),dbc.getPassword());
          this.DB = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_TEST","CSCI5308_12_TEST_USER","EJaiqueigahNg6cu");

//            System.out.println(this.DB);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("BRUHHHH");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return this.DB;

        }


    public void close(){
        try{
            this.DB.close();
        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        }
}

