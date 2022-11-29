package userProfile.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import userProfile.Records.UserTripsRecord;

public class TripDetailMenu implements IMenu {
    private final UserTripsRecord data;
    private final String userName;
    final String line = "======================================================";

    public TripDetailMenu(UserTripsRecord data, String userName) {
        this.data = data;
        this.userName = userName;

    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        // Print the user trip details
        System.out.println("Departure:" + this.data.departure());
        System.out.println("Destination: " + this.data.destination());
        System.out.println("Date Travelled: " + this.data.dateTravelled());
        System.out.println("Flight No: " + this.data.flightNo());
        System.out.println("Price : " + this.data.price());

        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your option: ");
        Scanner userOption = new Scanner(System.in);
        int option = userOption.nextInt();
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));

        return response;

    }
}
