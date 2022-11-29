package StaffHandling.View;

import java.util.*;

import StaffHandling.Records.StaffListRecord;

public class MenuEmployeeRecords implements IMenu {
    private final List<StaffListRecord> data;
    private final String userName;
    final String line = "======================================================";

    // Create constructor of Employee Records Menu
    public MenuEmployeeRecords(List<StaffListRecord> data, String userName) {
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
        });
        System.out.println("Enter Id for more Details");
        System.out.println("0. Back to Menu");
        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();
        System.out.println(this.line);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;

    }
}
