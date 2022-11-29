package userProfile.DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import userProfile.Records.UserDetailRecord;
import userProfile.UserDAO;

public class UserData extends UserDAO {
    private final String userName;
    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public UserData(String userName) {
        super();
        this.userName = userName;
        this.connection = getConnection();
    }

    // Fetch User Data from database
    public UserDetailRecord getUserData() {
        HashMap<String, String> data = new HashMap<>();
        UserDetailRecord userDetail;
        String sqlStatement = "SELECT userEmail, userName, userAddress, userContact from userDetails where userId=?";
        try {

            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, this.userName);
            this.resultSet = this.ExecuteSelect(preparedStatement);

            while(this.resultSet.next()) {
                String email = this.resultSet.getString("userEmail");
                String name = this.resultSet.getString("userName");
                String address = this.resultSet.getString("userAddress");
                String contact = this.resultSet.getString("userContact");
                userDetail = new UserDetailRecord(this.userName, email, name, address, contact);
                return userDetail;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    // Update User data in Database
    public Boolean updateData(UserDetailRecord data) {
        String sqlStatement = "UPDATE userDetails SET userEmail=?, userName=?, userAddress=?, userContact=?";
        try {
            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, data.email());
            this.preparedStatement.setString(2, data.name());
            this.preparedStatement.setString(3, data.address());
            this.preparedStatement.setString(4, data.contact());

            return this.ExecuteUpdate(preparedStatement);

        } catch (Exception e) {
            return false;
        }
    }
}
