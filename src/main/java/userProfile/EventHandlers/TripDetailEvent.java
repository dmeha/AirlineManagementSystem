package userProfile.EventHandlers;

import java.util.ArrayList;
import java.util.HashMap;

import userProfile.View.TripDetailMenu;
import userProfile.View.IMenu;
import userProfile.Records.UserTripsRecord;

public class TripDetailEvent implements Event {
    public HashMap<String, String> data;
    private String userName;
    private final UserTripsRecord ticket;

    public TripDetailEvent(String userName, UserTripsRecord ticket) {
        this.userName = userName;
        this.ticket = ticket;
    }

    @Override
    public Event handle() {

        IMenu ticketDetail = new TripDetailMenu(this.ticket, this.userName);
        HashMap<String, ArrayList<String>> userResp = ticketDetail.getMenu();

        String option = userResp.get("option").get(0);
        return this.chooseNextEvent(Integer.parseInt(option)); // Convert String option to Integer

    }


    public Event chooseNextEvent(int option) {
        Event responseEvent = null;
        if (option == 0) {
            // Back to Main Menu
            responseEvent = new UserProfileEvent(this.userName);

        } else {
            System.out.println("Enter Valid Option");
            this.handle();
        }
        return responseEvent;
    }
}
