package userProfile.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import userProfile.Records.UserDetailRecord;
public class UserProfileMenu implements IMenu {
    private final UserDetailRecord data;
    private final String userName;
    final String primaryLine = "======================================================";
    final String secondaryLine = "------------------------------------------------------";
    public UserProfileMenu(UserDetailRecord data, String userName){
        this.data = data;
        this.userName = userName;
    }
    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.primaryLine);
        System.out.println(this.userName);
        System.out.println(this.primaryLine);
        System.out.println("Name: " +data.name());
        System.out.println("Email:" + data.email());
        System.out.println("Contact: " + data.contact());
        System.out.println("Address: "+ data.address());
        System.out.println(this.secondaryLine);
        System.out.println("1.Previous Trips");
        System.out.println("2.Edit Profile");
        System.out.println("3.Reward Points Stats");
        System.out.println("0.Back to Main Menu");
        Scanner inputOption = new Scanner(System.in);
        System.out.println(this.secondaryLine);
        System.out.print("Enter your option: ");
        int option = inputOption.nextInt();
        System.out.println(this.primaryLine);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;
    }
}
