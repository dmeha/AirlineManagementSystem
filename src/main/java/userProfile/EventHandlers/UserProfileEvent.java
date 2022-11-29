package userProfile.EventHandlers;

import userProfile.View.*;
import userProfile.DataLayer.UserData;
import userProfile.Records.UserDetailRecord;

import java.util.ArrayList;
import java.util.HashMap;

public class UserProfileEvent implements Event {
    public UserDetailRecord data;
    private String userName;

    public UserProfileEvent(String userName) {
        this.userName = userName;

    }

    @Override
    public Event handle() {
        // Creating object of User data Model
        UserData userData = new UserData(this.userName);
        this.data = userData.getUserData(); // Get user data

        // Creating object of Menu User Profile
        IMenu userProfile = new UserProfileMenu(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = userProfile.getMenu();

        String option = userResp.get("option").get(0);
        return this.chooseNextEvent(Integer.parseInt(option)); // Convert String option to Integer
    }


    public Event chooseNextEvent(int option) {
        Event responseEvent = null;

        if (option == 1) {
            // Call Previous Trip Controller
            responseEvent = new PreviousTripsEvent(this.userName);

        } else if (option == 2) {
            // Call Edit Profile Controller
            responseEvent = new EditProfileEvent(this.userName, this.data);

        } else if (option == 3) {
            // Call Reward Details Controller
            responseEvent = new RewardDetailEvent(this.userName);

        } else if (option == 0) {
            responseEvent = null;
        } else {
            System.out.println("Enter Valid Option");
            this.handle();
        }
        return responseEvent;


    }
}
