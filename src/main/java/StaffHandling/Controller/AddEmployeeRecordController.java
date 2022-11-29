package StaffHandling.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import StaffHandling.Model.AddEmployeeData;
import StaffHandling.View.IMenu;
import StaffHandling.View.MenuAddEmployeeRecord;

public class AddEmployeeRecordController implements IController {
    private String userName;
    public HashMap<String, String> data;
    ArrayList<String> formResponse;

    // Create Constructor of Add Employee Record
    public AddEmployeeRecordController(String userName) {
        this.userName = userName;

    }

    @Override
    public void controller() {

        IMenu menu = new MenuAddEmployeeRecord(this.userName);
        HashMap<String, ArrayList<String>> userResp = menu.getMenu();

        this.formResponse = userResp.get("formData");

        String option = userResp.get("option").get(0);

        this.getSubMenu(Integer.parseInt(option)); // Convert String option to Integer
    }

    @Override
    public void getSubMenu(int option) {
        if (option == 0) {

        } else if (option == 1) {
            System.out.println("Form Saved");
            new AddEmployeeData().addData(this.formResponse); // Adding Employee data to Form Response
        } else {
            System.out.println("Enter Valid option");
            this.controller();
        }

    }
}
