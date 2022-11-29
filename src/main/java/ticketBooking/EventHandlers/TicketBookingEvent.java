package ticketBooking.EventHandlers;
import ticketBooking.View.*;

import java.util.ArrayList;
import java.util.HashMap;

public class TicketBookingEvent implements Event {
    private String userName;
    private final String line = "====================================================";


    public TicketBookingEvent(String userName){
        this.userName = userName;
    }

    @Override
    public Event handle() {
        Menu ticketBooking = new TicketBookingMenu(this.userName);
        HashMap<String, ArrayList<String>> userResp = ticketBooking.getMenu();
        String option = userResp.get("option").get(0);

        return this.getSubMenu(Integer.parseInt(option));

    }


    private Event getSubMenu(int option){
        Event responseController = null;
        if(option == 1){
            responseController = new RouteSelectionEvent(this.userName);

        }else if(option == 0){
            responseController = null;

        }else{
            System.out.println("Enter Valid Option ");
            this.handle();

        }


        return responseController;
    }
}
