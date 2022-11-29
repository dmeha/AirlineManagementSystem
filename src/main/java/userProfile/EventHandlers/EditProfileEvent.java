package userProfile.EventHandlers;

import java.util.ArrayList;
import java.util.HashMap;

import userProfile.Records.UserDetailRecord;
import userProfile.DataLayer.UserData;
import userProfile.View.IMenu;
import userProfile.View.EditProfileView;

public class EditProfileEvent implements Event {

    private String userName;
    public UserDetailRecord data;
    ArrayList<String> formResponse;

    public EditProfileEvent(String userName, UserDetailRecord data) {
        this.userName = userName;
        this.data = data;
    }

    @Override
    public Event handle() {


        IMenu editProfile = new EditProfileView(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = editProfile.getMenu();
        this.formResponse = userResp.get("formData");
        String option = userResp.get("option").get(0);
        return this.chooseNextEvent(Integer.parseInt(option)); // Convert String option to Integer

    }


    public Event chooseNextEvent(int option) {
        Event responseEvent = null;

        if (option == 1) {
            HashMap<String, String> updateData = getChanges();
            UserData uD = new UserData(this.userName);
            UserDetailRecord userUpdatedDetailRecord = new UserDetailRecord(this.userName, updateData.get("email"), updateData.get("name"),
                    updateData.get("address"), updateData.get("contact"));
            uD.updateData(userUpdatedDetailRecord);

            responseEvent = new UserProfileEvent(this.userName);
        } else if (option == 0) {
            responseEvent = new UserProfileEvent(this.userName);
        } else {
            System.out.println("Enter Valid Option");
            this.handle();
        }
        return responseEvent;

    }

    public HashMap<String, String> getChanges() {
        HashMap<String, String> formData = new HashMap<>();
        formData.put("email", formResponse.get(0));
        formData.put("name", formResponse.get(1));
        formData.put("address", formResponse.get(2));
        formData.put("contact", formResponse.get(3));

        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", this.data.name());
        userData.put("email", this.data.email());
        userData.put("address", this.data.address());
        userData.put("contact", this.data.contact());


        formData.forEach((key, value) -> {
            if (value != null) {
                if (value.isEmpty()) {
                    formData.put(key, userData.get(key));
                }
            } else {
                return;
            }
        });

        formData.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });


        return formData;

    }
}
