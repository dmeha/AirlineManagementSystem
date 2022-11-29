package StaffHandling.View;

import java.util.*;

public class MenuAddEmployeeRecord implements IMenu {
    private final HashMap<String, String> data;
    private final String userName;
    final String line = "======================================================";

    // Create constructor of Add Employee Record Menu
    public MenuAddEmployeeRecord(String userName) {
        this.userName = userName;
        this.data = new HashMap<>();
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);

        Scanner nameInput = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = nameInput.nextLine();

        Scanner addressInput = new Scanner(System.in);
        System.out.print("Enter Address: ");
        String address = addressInput.nextLine();

        Scanner contactInput = new Scanner(System.in);
        System.out.print("Enter Contact No: ");
        String contact = contactInput.nextLine();

        Scanner emailInput = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = emailInput.nextLine();

        Scanner roleInput = new Scanner(System.in);
        System.out.print("Enter Role: ");
        String role = roleInput.nextLine();

        System.out.println("1. Save Form");

        System.out.println("0. Back to Main Menu");
        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();

        System.out.println(this.line);
        ArrayList<String> form = new ArrayList<>(Arrays.asList(name, address, contact, email, role));
        response.put("formData", form);

        response.put("option", new ArrayList<>(Collections.singleton(Integer.toString(option))));

        return response;

    }
}
