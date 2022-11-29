package StaffHandling.View;

import java.util.*;

public class MenuEditEmployeeRecord implements IMenu {

    private final String userName;
    final String line = "======================================================";

    // Create constructor of Update Employee Record Menu
    public MenuEditEmployeeRecord(String userName) {
        this.userName = userName;

    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        Scanner idInput = new Scanner(System.in);

        System.out.println("Leave Field Blank to ignore edit");
        System.out.print("Enter id: ");
        String id = idInput.nextLine();

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

        System.out.println("1. Update Record");
        System.out.println("0. Back to Main Menu");

        System.out.print("Enter your option: ");
        Scanner userOption = new Scanner(System.in);
        String option = userOption.nextLine();

        System.out.println(this.line);

        ArrayList<String> form = new ArrayList<>(Arrays.asList(id, name, address, contact, email, role));
        response.put("formData", form);

        response.put("option", new ArrayList<>(Collections.singleton(option)));

        return response;
    }
}
