package StaffHandling.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MenuStaffHandling implements IMenu {
    private final HashMap<String, String> data;
    private final String Line = "=======================================================";
    private final String userName;

    // Create constructor for Staff Handling Menu
    public MenuStaffHandling(HashMap<String, String> data, String userName) {
        this.data = data;
        this.userName = userName;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.Line);
        System.out.println(this.userName);
        System.out.println(this.Line);
        System.out.println("1. View Employee Record");
        System.out.println("2. Add Employee Record");
        System.out.println("3. Update Employee Record");
        System.out.println("4. Delete Employee Record");

        System.out.println("0. Back to Main Menu");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = sc.nextInt();
        System.out.println(this.Line);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;

    }
}
