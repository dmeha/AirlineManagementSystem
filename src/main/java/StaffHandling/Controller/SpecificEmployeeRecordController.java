package StaffHandling.Controller;

import StaffHandling.View.*;
import StaffHandling.View.MenuSpecificEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import StaffHandling.Records.StaffListRecord;

public class SpecificEmployeeRecordController implements IController {
    public String userName;
    public int empId;
    public List<StaffListRecord> data;
    public List<StaffListRecord> staffData = new ArrayList<>();

    // Create Constructor of Specific Employee Records
    public SpecificEmployeeRecordController(String userName, int empId, List<StaffListRecord> staffData) {
        this.userName = userName;
        this.empId = empId;
        this.data = staffData;
    }

    @Override
    public void controller() {

        this.data.forEach(staff -> {
            if (staff.id().equalsIgnoreCase(Integer.toString(empId))) {
                this.staffData.add(staff);
            }
        });
        IMenu empProfile = new MenuSpecificEmployee(this.staffData, this.userName);

        HashMap<String, ArrayList<String>> userResp = empProfile.getMenu();

        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option)); // Convert String option to Integer

    }

    @Override
    public void getSubMenu(int options) {
    }

}
