package StaffHandling.Controller;

import StaffHandling.View.IMenu;
import StaffHandling.View.MenuDeleteEmployeeRecord;

import java.util.ArrayList;
import java.util.HashMap;

import StaffHandling.Model.ListOfEmployee;

public class DeleteEmployeeRecordController implements IController {
    private final HashMap<String, String> data;
    private String staffId;
    private final String userName;

    // Create Constructor of Delete Employee Record
    public DeleteEmployeeRecordController(String userName) {
        this.userName = userName;
        this.data = new HashMap<>();
    }

    @Override
    public void controller() {
        IMenu deleteMenu = new MenuDeleteEmployeeRecord(this.userName);
        HashMap<String, ArrayList<String>> userResp = deleteMenu.getMenu();
        staffId = userResp.get("form").get(0);
        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option)); // Convert String option to Integer

    }

    @Override
    public void getSubMenu(int option) {
        if (option == 1) {
            new ListOfEmployee().deleteEmployee(staffId); // Deleting Employee data of given StaffId
            System.out.println("Record Deleted");
        }
    }


}
