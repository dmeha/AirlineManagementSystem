package ticketBooking.EventHandlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import ticketBooking.Records.RouteSelectionRecord;
import RouteFinder.RouteFinder;
import RouteFinder.Flight;
import ticketBooking.View.FlightListMenu;
import ticketBooking.View.Menu;


public class FlightListEvent implements Event {
    private String userName;

    private ArrayList<RouteSelectionRecord> data = new ArrayList<>();
    private List<List<Flight>> flights = new ArrayList<>();
    public FlightListEvent(String userName, ArrayList<String> bookingData){
        RouteSelectionRecord r = new RouteSelectionRecord(bookingData.get(0), bookingData.get(1), bookingData.get(2));
        this.data.add(r);
        this.userName = userName;

    }



    @Override
    public Event handle() {
        flights = new RouteFinder(data.get(0).destination(), data.get(0).departure(), data.get(0).startDate()).find();

        Menu menu = new FlightListMenu(flights , this.userName);
        HashMap<String, ArrayList<String>> userResp = menu.getMenu();
        String option = userResp.get("option").get(0);
        return this.chooseNextEvent(Integer.parseInt(option));

    }

    public Event chooseNextEvent(int option){
        Event responseController = null;
        if(option == 0){

        }
        else{
            responseController = new PaymentGatewayEvent(this.userName, flights.get(option-1));

        }
        return responseController;
    }



}
