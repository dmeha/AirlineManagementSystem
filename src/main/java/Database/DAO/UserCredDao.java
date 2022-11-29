package Database.DAO;

import Database.DatabaseConnection;
import Database.Entities.User;
import Database.Mode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserCredDao implements CURD {

    Mode mode;
    Connection conn;
    Statement queryStatement = null;
    ResultSet responseSet = null;

    //Try making this Singleton also
    public UserCredDao(Mode mode) {
        this.mode = mode;
        DatabaseConnection dc = new DatabaseConnection(this.mode);
        this.conn = dc.connect();
    }



    public boolean CheckExisting(User user){
        return false;
    }

    public void closeDBConnection(){
        try{
        this.conn.close();
        }catch (SQLException ignored){}
    }



    @Override
    public Object createOne(Object singleObject) {

        User user = (User) singleObject;

        try {
//            Connection con = DriverManager.getConnection()
            this.queryStatement = conn.createStatement();
            String query = String.format(
                    "INSERT INTO `usersCreds` (`email`,`username`, `password`,`securityQuestion`,`securityAnswer`,`role`) VALUES ('%s', '%s', '%s', '%s', '%s','%s')",
                    user.getEmail(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getSecurityQuestion(),
                    user.getSecurityAnswer(),
                    user.getRole()
            );
            this.queryStatement.executeUpdate(query);

        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (responseSet != null) {
                try {
                    responseSet.close();
                } catch (SQLException ignored) {
                } // ignore
                responseSet = null;
            }
            if (this.queryStatement != null) {
                try {
                    this.queryStatement.close();
                } catch (SQLException ignored) {
                } // ignore
                this.queryStatement = null;
            }
        }

        return (Object) user;
    }

    @Override
    public void createMany(List<Object> objects) {}

    @Override
    public User getOneByUsername(String username) {
        ArrayList<User> users = new ArrayList<>();
         try {
             this.queryStatement = conn.createStatement();
             responseSet = this.queryStatement.executeQuery("SELECT * FROM usersCreds WHERE username='"+username+"'");

             while (responseSet.next()) {
                 int id = responseSet.getInt("id");
                 String email = responseSet.getString("email");
                 String _username = responseSet.getString("username");
                 String _password = responseSet.getString("password");
                 String securityQuestion = responseSet.getString("securityQuestion");
                 String securityAnswer = responseSet.getString("securityAnswer");
                 String role = responseSet.getString("role");
                 User u = new User(_username,_password);
                 u.setEmail(email);
                 u.setSecurityQuestion(securityQuestion);
                 u.setSecurityAnswer(securityAnswer);
                 u.setId(id);
                 u.setRole(role);
                 users.add(u);
             }
         }
         catch (SQLException ex){
             // handle any errors
             System.out.println("SQLException: " + ex.getMessage());
             System.out.println("SQLState: " + ex.getSQLState());
             System.out.println("VendorError: " + ex.getErrorCode());
         }

        return users.size() >= 1 ? users.get(0): null;
    }

    @Override
    public User getOneById(int id) {
        ArrayList<User> users = new ArrayList<>();
        try {
            this.queryStatement = conn.createStatement();
            responseSet = this.queryStatement.executeQuery("SELECT * FROM usersCreds WHERE id='"+String.valueOf(id)+"'");

            while (responseSet.next()) {
                int i = responseSet.getInt("id");
                String email = responseSet.getString("email");
                String _username = responseSet.getString("username");
                String _password = responseSet.getString("password");
                String securityQuestion = responseSet.getString("securityQuestion");
                String securityAnswer = responseSet.getString("securityAnswer");
                User u = new User(_username,_password);
                u.setEmail(email);
                u.setSecurityQuestion(securityQuestion);
                u.setSecurityAnswer(securityAnswer);
                u.setId(i);
                users.add(u);
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return users.get(0);
    }
    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> users = new ArrayList<>();
        try {
            this.queryStatement = conn.createStatement();
            responseSet = this.queryStatement.executeQuery("SELECT * FROM usersCreds");
            while (responseSet.next()) {
                int id = responseSet.getInt("id");
                String email = responseSet.getString("email");
                String _username = responseSet.getString("username");
                String _password = responseSet.getString("password");
                String securityQuestion = responseSet.getString("securityQuestion");
                String securityAnswer = responseSet.getString("securityAnswer");
                User u = new User(_username,_password);
                u.setEmail(email);
                u.setSecurityQuestion(securityQuestion);
                u.setSecurityAnswer(securityAnswer);
                u.setId(id);
                users.add(u);
            }
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (responseSet != null) {
                try {
                    responseSet.close();
                } catch (SQLException ignored) {
                } // ignore
                responseSet = null;
            }
            if (this.queryStatement != null) {
                try {
                    this.queryStatement.close();
                } catch (SQLException ignored) {
                } // ignore
                this.queryStatement = null;
            }
        }
        return users;
    }

    @Override
    public void FindOneAndUpdate(Object singleObject) {

    }

    @Override
    public void findOneAndDelete(Object singleObject) {

    }
}
