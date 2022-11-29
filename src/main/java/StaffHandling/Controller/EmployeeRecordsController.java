package StaffHandling.Controller;

import StaffHandling.Model.ListOfEmployee;
import StaffHandling.View.IMenu;
import StaffHandling.View.MenuEmployeeRecords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import StaffHandling.Records.StaffListRecord;

public class EmployeeRecordsController implements IController {
    private String userName;
    public List<StaffListRecord> data;
    ArrayList<String> formResponse;

    // Create Constructor of Employee Records
    public EmployeeRecordsController(String userName) {
        this.userName = userName;
    }

    @Override
    public void controller() {
        ListOfEmployee list = new ListOfEmployee();
        this.data = list.getEmployeeData();
        IMenu editProfile = new MenuEmployeeRecords(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = editProfile.getMenu();
        this.formResponse = userResp.get("formData");
        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option)); // Convert String option to Integer
    }

    @Override
    public void getSubMenu(int options) {
        if (options == 0) {

        } else {
            SpecificEmployeeRecordController specificRecordController = new SpecificEmployeeRecordController(this.userName, options, this.data);
            specificRecordController.controller(); // Calling Controller of Specific Employee Record
        }

    }
}
