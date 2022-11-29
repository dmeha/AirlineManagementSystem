package StaffHandling.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AddEmployeeData extends DAO {
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public AddEmployeeData() {
        super();
    }

    public void addData(ArrayList<String> data) {
        // Insert query to Add Employee Data
        String sqlStatement = "INSERT INTO staff (`staffName`, `staffAddress`, `staffContact`, `staffEmail`, `staffRole` ) VALUES (?, ?, ?, ?, ?);";

        try {

            String name = data.get(0);
            String address = data.get(1);
            String contact = data.get(2);
            String email = data.get(3);
            String role = data.get(4);

            this.connection = getConnection(); // To make Connection with database
            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, name);
            this.preparedStatement.setString(2, address);
            this.preparedStatement.setString(3, contact);
            this.preparedStatement.setString(4, email);
            this.preparedStatement.setString(5, role);

            this.preparedStatement.execute(); // To execute update

            // To catch Exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
