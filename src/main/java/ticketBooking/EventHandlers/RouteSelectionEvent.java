package ticketBooking.EventHandlers;

import ticketBooking.View.Menu;
import ticketBooking.View.RouteSelectionMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteSelectionEvent implements Event {
    private final String userName;
    private ArrayList<String> formResponse;
    public RouteSelectionEvent(String userName){
        this.userName = userName;
    }
    @Override
    public Event handle() {
        Menu routeSelection = new RouteSelectionMenu(this.userName);

        HashMap<String, ArrayList<String>> userResp = routeSelection.getMenu();
        this.formResponse = userResp.get("formData");

        String option = userResp.get("option").get(0);
        return this.chooseNextEvent(Integer.parseInt(option));

    }

    public Event chooseNextEvent(int option){
        Event responseController = null;
        if(option == 1){
            responseController = new FlightListEvent(this.userName, this.formResponse);

        }
        else if(option == 0){
            responseController = new TicketBookingEvent(this.userName);
        }
        else {
            System.out.println("Enter Valid Option");
            this.handle();
        }
        return responseController;
    }
}
