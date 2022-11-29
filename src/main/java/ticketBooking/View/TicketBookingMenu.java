package ticketBooking.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class TicketBookingMenu implements Menu {
    private final String userName;
    final String line = "======================================================";
    public TicketBookingMenu(String userName){
        this.userName = userName;

    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();

        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        System.out.println("1. Select Route");
        System.out.println("0. Back to Main Menu");

        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();

        System.out.println(this.line);
        response.put("option", new ArrayList<>(Collections.singleton(Integer.toString(option))));
        return response;



    }
}
