package userProfile.View;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import userProfile.Records.UserTripsRecord;

public class PreviousTripsMenu implements IMenu {
    private final List<UserTripsRecord> data;
    private final String userName;
    final String line = "======================================================";

    public PreviousTripsMenu(List<UserTripsRecord> data, String userName) {
        this.data = data;
        this.userName = userName;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        AtomicInteger counter = new AtomicInteger();
        this.data.forEach(trip -> {
            counter.getAndIncrement();
            System.out.println(counter + ": " + trip.departure() + " -> " + trip.destination()); //To Print User Previous Trips

        });
        System.out.println("to get more detail of the trip enter trip id");
        System.out.println("0. Back to Main Menu");
        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();
        System.out.println(this.line);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;
    }
}
