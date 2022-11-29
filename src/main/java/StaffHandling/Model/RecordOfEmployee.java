package StaffHandling.Model;

import StaffHandling.Records.StaffListRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecordOfEmployee extends DAO {
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public String userName;
    public int option;

    // Create constructor of Employee Record
    public RecordOfEmployee(String userName, int option) {
        this.userName = userName;
        this.option = option;
    }

    // Get Record of Specific Employee
    public List<StaffListRecord> getEmployeeRecord() {
        List<StaffListRecord> data = new ArrayList<>();
        String sqlStatement = "SELECT * from staff WHERE staffId= ?";
        try {
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, Integer.toString(option));

            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()) {
                String id = this.resultSet.getString("staffId");
                String name = this.resultSet.getString("staffName");
                String address = this.resultSet.getString("staffAddress");
                String contact = this.resultSet.getString("staffContact");
                String email = this.resultSet.getString("staffEmail");
                String role = this.resultSet.getString("staffRole");
                StaffListRecord staff = new StaffListRecord(id, name, address, contact, email, role);
                data.add(staff);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
