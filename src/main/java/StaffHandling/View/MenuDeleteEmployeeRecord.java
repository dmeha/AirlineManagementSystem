package StaffHandling.View;

import java.util.*;

public class MenuDeleteEmployeeRecord implements IMenu {
    private final HashMap<String, String> data;
    private final String userName;
    final String line = "======================================================";

    // Create constructor of Delete Employee Record Menu
    public MenuDeleteEmployeeRecord(String userName) {
        this.userName = userName;
        this.data = new HashMap<>();
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);

        Scanner idInput = new Scanner(System.in);
        System.out.print("Enter Staff id to Delete: ");
        String id = idInput.nextLine();

        System.out.println("1. Confirm");
        System.out.println("0. Back to Main Menu");

        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();

        ArrayList<String> form = new ArrayList<>(Arrays.asList(id));
        response.put("form", form);
        response.put("option", new ArrayList<>(Collections.singleton(Integer.toString(option))));
        return response;
    }

}
