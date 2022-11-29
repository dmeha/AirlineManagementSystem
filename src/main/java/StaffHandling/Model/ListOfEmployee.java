package StaffHandling.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import StaffHandling.Records.StaffListRecord;

public class ListOfEmployee extends DAO {
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ListOfEmployee() {
        this.connection = this.getConnection();
    }

    // Get Employee Data from Database
    public List<StaffListRecord> getEmployeeData() {
        List<StaffListRecord> data = new ArrayList<>();
        String sqlStatement = "SELECT * from staff";
        try {

            this.preparedStatement = this.connection.prepareStatement(sqlStatement);

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

    // Update specific field in Staff table
    public void updateEmployee(StaffListRecord staff) {
        String sqlStatement = "UPDATE `staff` SET staffName = ?, staffAddress = ?, staffContact = ?, staffEmail = ?, staffRole = ? WHERE (staffId = ?)";
        try {

            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, staff.name());
            this.preparedStatement.setString(2, staff.address());
            this.preparedStatement.setString(3, staff.contact());
            this.preparedStatement.setString(4, staff.email());
            this.preparedStatement.setString(5, staff.role());
            this.preparedStatement.setString(6, staff.id());
            this.preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Delete Employee record of given StaffId
    public void deleteEmployee(String id) {
        String sqlStatement = "DELETE FROM `staff` WHERE (`staffId` = ?)";
        try {
            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, id);
            this.preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
