package Transactions.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DateWiseTransactionMenu implements IMenu {
    private final HashMap<String, String> data;
    private final String Line = "=======================================================";
    private final String userName;

    public DateWiseTransactionMenu(HashMap<String, String> data, String userName) {
        this.data = data;
        this.userName = userName;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.Line);
        System.out.println(this.userName);
        System.out.println(this.Line);

        System.out.println("Enter Date: ");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        System.out.println("Enter Flight No: ");
        String flightNo = sc.nextLine();

        System.out.println(this.Line);
        response.put("date", new ArrayList<String>(Collections.singleton(date)));
        response.put("flightNo", new ArrayList<String>(Collections.singleton(flightNo)));
        return response;


    }
}
