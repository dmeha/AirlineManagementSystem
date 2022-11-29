package userProfile;

import userProfile.EventHandlers.Event;
import userProfile.EventHandlers.UserProfileEvent;

public class UserProfileController {
    Event userProfileEvent;



    public UserProfileController(String userName) {

        this.userProfileEvent = new UserProfileEvent(userName);
    }

    // Start controller till userProfile get null
    public void startController() {
        while (userProfileEvent != null) {

            userProfileEvent = this.userProfileEvent.handle();
        }

    }

}
