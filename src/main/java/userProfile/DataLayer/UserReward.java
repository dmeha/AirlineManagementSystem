package userProfile.DataLayer;

import userProfile.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class UserReward extends UserDAO {
    private final String userName;
    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public UserReward(String userName) {


        super();
        this.userName = userName;
        this.connection = getConnection();
    }

    // Fetch Data from RewardPoints table from database
    public HashMap<String, String> getData() {
        HashMap<String, String> data = new HashMap<>();
        try {

            // For Total Reward points
            String sqlStatement = "SELECT SUM(point) from rewardPoints WHERE userId=?";

            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, this.userName);

            this.resultSet = this.ExecuteSelect(preparedStatement);
            int counter = 0;
            while (this.resultSet.next()) {
                String point = this.resultSet.getString(1);
                counter++; // Counter Increase
                data.put(Integer.toString(counter), point); // Convert Integer counter to String
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
