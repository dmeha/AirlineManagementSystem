package userProfile.EventHandlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import userProfile.Records.UserTripsRecord;
import userProfile.DataLayer.UserTrips;
import userProfile.View.*;

public class PreviousTripsEvent implements Event {
    public List<UserTripsRecord> data;
    private String userName;

    public PreviousTripsEvent(String userName) {
        this.userName = userName;
    }

    @Override
    public Event handle() {
        UserTrips userTrips = new UserTrips(this.userName);
        this.data = userTrips.getData();

        IMenu previousTrips = new PreviousTripsMenu(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = previousTrips.getMenu();

        String option = userResp.get("option").get(0);
        return this.chooseNextEvent(Integer.parseInt(option)); // Convert String option to Integer
    }


    public Event chooseNextEvent(int option) {
        Event responseEvent = null;
        if (option == 0) {
            responseEvent = new UserProfileEvent(this.userName);
        } else {
            try {
                // Call Trip Detail Controller
                responseEvent = new TripDetailEvent(this.userName, this.data.get(option - 1));

            } catch (Exception e) {
                System.out.println("Enter Valid Option");
                this.handle();
            }

        }
        return responseEvent;


    }
}
