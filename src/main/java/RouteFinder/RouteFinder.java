package RouteFinder;

import RouteFinder.dbOps.ListFlights;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RouteFinder {
    private String destination;
    private String departure;
    private String startDate;
    public HashMap<Integer, ArrayList<ArrayList<String>>> resultFlight;

    public RouteFinder(String destination, String departure, String startDate) {
        this.destination = destination;
        this.departure = departure;
        this.startDate = startDate;
        resultFlight = new HashMap<>();


    }


    public List<List<Flight>> find() {
        List<List<Flight>> finalFlights = new ArrayList<>();
        List<Flight> flightList = new ListFlights().getData(this.departure, this.startDate);
        flightList.forEach(flight -> {
            if (verifyDestination(flight)) {
                finalFlights.add(List.of(flight));
            } else {
                findConnectingFlights(finalFlights, flight);
            }
        });
        return finalFlights;
    }

    private void findConnectingFlights(List<List<Flight>> finalFlights, Flight flight) {
        new ListFlights().getData(flight.destination(), this.startDate)
                .forEach(connectingFlight -> {
                    if (verifyDestination(connectingFlight) && flight.landingTime().before(connectingFlight.takeOffTime())) {
                        finalFlights.add(List.of(flight, connectingFlight));
                    }
                });
    }

    private boolean verifyDestination(Flight connectingFlight) {
        return connectingFlight.destination().equalsIgnoreCase(this.destination);
    }


}
