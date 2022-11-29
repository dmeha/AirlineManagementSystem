package ticketBooking.View;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import RouteFinder.Flight;

public class FlightListMenu implements Menu {
    private List<List<Flight>> data;
    private final String userName;
    final String line = "======================================================";
    public FlightListMenu(List<List<Flight>> data, String userName){
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
        counter.getAndIncrement();
        data.forEach(flights -> {

            System.out.print(counter.getAndIncrement() +": ");

            flights.forEach(subFlights -> {
                System.out.print(subFlights.departure() +" to " + subFlights.destination() +"->");
            });
            System.out.println("");
        });

        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your option: ");
        Scanner userOption = new Scanner(System.in);
        int option = userOption.nextInt();
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));

        return response;

    }
}
