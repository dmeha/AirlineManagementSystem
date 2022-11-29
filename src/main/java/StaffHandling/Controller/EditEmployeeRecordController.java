package StaffHandling.Controller;

import StaffHandling.Model.ListOfEmployee;
import StaffHandling.Model.RecordOfEmployee;
import StaffHandling.View.IMenu;
import StaffHandling.View.MenuEditEmployeeRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import StaffHandling.Records.StaffListRecord;

public class EditEmployeeRecordController implements IController {
    public String userName;
    public List<StaffListRecord> data;
    private ArrayList<String> formResponse = new ArrayList<>();

    // Create Constructor of Update field in Employee Record
    public EditEmployeeRecordController(String userName) {
        this.userName = userName;
    }

    @Override
    public void controller() {
        IMenu menu = new MenuEditEmployeeRecord(this.userName);

        HashMap<String, ArrayList<String>> userResp = menu.getMenu();

        String option = userResp.get("option").get(0);

        this.formResponse = userResp.get("formData");

        this.getSubMenu(Integer.parseInt(option)); // Convert String option to Integer
    }

    @Override
    public void getSubMenu(int option) {
        if (option == 1) {
            HashMap<String, String> updateData = getChanges();
            StaffListRecord staff = new StaffListRecord(formResponse.get(0), updateData.get("name"), updateData.get("address"),
                    updateData.get("contact"), updateData.get("email"), updateData.get("role")); // Updating Employee data of given field

            new ListOfEmployee().updateEmployee(staff);


        }

    }

    public HashMap<String, String> getChanges() {
        this.data = new RecordOfEmployee(this.userName, Integer.parseInt(formResponse.get(0))).getEmployeeRecord();
        HashMap<String, String> formData = new HashMap<>();

        // Updating in Form Response
        formData.put("name", formResponse.get(1));
        formData.put("address", formResponse.get(2));
        formData.put("contact", formResponse.get(3));
        formData.put("email", formResponse.get(4));
        formData.put("role", formResponse.get(5));

        StaffListRecord list = this.data.get(0);
        HashMap<String, String> staffData = new HashMap<>();
        staffData.put("name", list.name());
        staffData.put("address", list.address());
        staffData.put("contact", list.contact());
        staffData.put("email", list.email());
        staffData.put("role", list.role());

        formData.forEach((key, value) -> {
            if (value != null) {
                if (value.isEmpty()) {
                    formData.put(key, staffData.get(key));
                }
            } else {
                return;
            }
        });
        return formData;
    }

}
