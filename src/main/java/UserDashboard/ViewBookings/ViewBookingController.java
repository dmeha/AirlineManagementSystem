package UserDashboard.ViewBookings;

import Database.Entities.User;
import UserDashboard.UserDashboardUI;

import java.util.Stack;

public class ViewBookingController {

    //variables
    private static ViewBookingController viewBookingController =null;
    private User authenticatedUser = null;
    private Stack<String> processStack = new Stack<String>(){
        {
            add("firstPaint");
        }
    };

    private ViewBookingController(User _authenticatedUser){
        this.authenticatedUser = _authenticatedUser;
    }

    //Singlton class
    public static ViewBookingController getController(User _authenticatedUser){
        if(viewBookingController == null){
            viewBookingController = new ViewBookingController(_authenticatedUser);
        }
        return viewBookingController;
    }

    public boolean runner() {

        while (!processStack.isEmpty()) {
            //first paint
            int selectedOptionAfterFirstPaint;
            if (processStack.peek().equals("firstPaint")) {
                selectedOptionAfterFirstPaint = ViewBookingUI.firstPaint(this.authenticatedUser);


                switch (selectedOptionAfterFirstPaint) {
                    case 0 -> {
                        processStack.clear();
                        processStack.add("firstPaint");
                        System.out.println("SYSTEM: Select an appropriate option");
//                        return false;
                    }
                    case 4 -> {
                        processStack.clear();
                        processStack.add("firstPaint");
                        return false;
                    }
                    default -> {
                        processStack.add("details");
                        int looking = ViewBookingUI.bookingDetails(this.authenticatedUser);
                        if (looking !=4) {
                            System.out.println("SYSTEM: Select an appropriate option, Going back..");
                            processStack.pop();
                        }
                    }
                }


                }
            }
        // FOR MOVING FORWARD
        return true;
    }
}
