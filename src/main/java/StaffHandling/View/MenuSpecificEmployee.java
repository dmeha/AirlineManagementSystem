package StaffHandling.View;

import java.util.*;

import StaffHandling.Records.StaffListRecord;

public class MenuSpecificEmployee implements IMenu {
    private List<StaffListRecord> data;
    private String userName;
    final String line = "======================================================";

    // Create constructor for Specific Employee Menu
    public MenuSpecificEmployee(List<StaffListRecord> data, String userName) {
        this.data = data;
        this.userName = userName;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        this.data.forEach(staff -> {
            System.out.println("id: " + staff.id());
            System.out.println("name: " + staff.name());
            System.out.println("contact: " + staff.contact());
            System.out.println("Address: " + staff.address());
        });
        System.out.println("0.Back to Main Menu");
        Scanner inputOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = inputOption.nextInt();
        System.out.println(this.line);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;

    }
}
