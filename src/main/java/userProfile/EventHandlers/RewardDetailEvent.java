package userProfile.EventHandlers;

import java.util.ArrayList;
import java.util.HashMap;

import userProfile.DataLayer.UserReward;
import userProfile.View.IMenu;
import userProfile.View.RewardDetailMenu;

public class RewardDetailEvent implements Event {
    public HashMap<String, String> data;
    private String userName;

    public RewardDetailEvent(String userName) {
        this.userName = userName;
    }

    @Override
    public Event handle() {
        UserReward userReward = new UserReward(this.userName);
        this.data = userReward.getData();

        IMenu rewardDetail = new RewardDetailMenu(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = rewardDetail.getMenu();

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
