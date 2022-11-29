package Transactions.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class SpecificTransactionCostMenu implements IMenu {
    private HashMap<String, String> data;
    private String userName;
    final String line = "======================================================";

    public SpecificTransactionCostMenu(HashMap<String, String> data, String userName) {
        this.data = data;
        this.userName = userName;
    }


    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        this.data.forEach((key, value)-> {
            System.out.println(key +": "+ value);
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
