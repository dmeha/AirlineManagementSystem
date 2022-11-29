package userProfile.View;

import java.util.*;

import userProfile.Records.UserDetailRecord;

public class EditProfileView implements IMenu {
    private final UserDetailRecord data;
    private final String userName;
    final String line = "======================================================";

    public EditProfileView(UserDetailRecord data, String userName) {
        this.data = data;
        this.userName = userName;


    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        System.out.println("Leave the field blank to avoid change");

        Scanner inputEmail = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = inputEmail.nextLine();

        Scanner inputName = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = inputName.nextLine();

        Scanner inputAddress = new Scanner(System.in);
        System.out.print("Enter Address: ");
        String address = inputAddress.nextLine();

        Scanner inputContact = new Scanner(System.in);
        System.out.print("Enter Contact No: ");
        String contact = inputContact.nextLine();

        System.out.println("");
        System.out.println("1. Save Changes");
        System.out.println("0. Back to Main Menu");

        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();
        ArrayList<String> form = new ArrayList<>(Arrays.asList(email, name, address, contact));
        response.put("formData", form);
        System.out.println(this.line);
        response.put("option", new ArrayList<>(Collections.singleton(Integer.toString(option))));

        return response;
    }
}
