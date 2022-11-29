package userProfile.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class RewardDetailMenu implements IMenu {
    private final HashMap<String, String> data;
    private final String userName;
    final String line = "======================================================";

    public RewardDetailMenu(HashMap<String, String> data, String userName) {
        this.data = data;
        this.userName = userName;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        this.data.forEach((key, value) -> {
            System.out.println("Total Points : " + value); // Print Total Reward Points of users
        });
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your option: ");
        Scanner userOption = new Scanner(System.in);
        int option = userOption.nextInt();
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));

        return response;
    }
}
