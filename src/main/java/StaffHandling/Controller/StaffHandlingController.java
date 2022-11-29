package StaffHandling.Controller;

import StaffHandling.View.*;
import StaffHandling.View.MenuStaffHandling;

import java.util.ArrayList;
import java.util.HashMap;

public class StaffHandlingController implements IController {
    private String userName;
    public HashMap<String, String> data;
    ArrayList<String> formResponse;

    // Create Constructor of Staff Handling
    public StaffHandlingController(String userName) {
        this.userName = userName;
        this.data = new HashMap<>();


    }

    @Override
    public void controller() {
        IMenu staffHandling = new MenuStaffHandling(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = staffHandling.getMenu();
        this.formResponse = userResp.get("formData");
        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option)); // Convert String option to Integer

    }

    @Override
    public void getSubMenu(int option) {
        if (option == 0) {
        } else if (option == 1) {
            IController employeeController = new EmployeeRecordsController(this.userName);
            employeeController.controller(); // Calling Controller of Employee Records
        } else if (option == 2) {
            IController addEmployeeRecord = new AddEmployeeRecordController(this.userName);
            addEmployeeRecord.controller(); // Calling Controller of Add Employee Records
        } else if (option == 3) {
            IController editEmployeeRecord = new EditEmployeeRecordController(this.userName);
            editEmployeeRecord.controller(); // Calling Controller of Update Employee Records
        } else if (option == 4) {
            IController deleteEmployee = new DeleteEmployeeRecordController(this.userName);
            deleteEmployee.controller(); // Calling Controller of Delete Employee Records
        } else {
            System.out.println("Enter Valid Option");
            this.controller();
        }

    }

}
