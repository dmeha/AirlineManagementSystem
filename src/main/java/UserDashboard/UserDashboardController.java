package UserDashboard;

import Authentication.AuthController;
import UserDashboard.ViewBookings.ViewBookingController;
import ticketBooking.TicketBookingController;
import userProfile.UserProfileController;


import java.util.Stack;

public class UserDashboardController {

    private static UserDashboardController controller = null;
    private AuthController authController = null;
    private static final Stack<String> processStack = new Stack<String>(){
        {
            push("firstPaint");
        }
    };
    private UserDashboardController(AuthController _authController){
        authController = _authController;
    }

    //Singleton controller
    public static UserDashboardController getController(AuthController _authController){
        if(controller==null){
            controller = new UserDashboardController(_authController);

        }
        return controller;
    }


    public  boolean runner(){

        while(!processStack.isEmpty()){
            //first paint
            int selectedOptionAfterFirstPaint;
            if(processStack.peek().equals("firstPaint")){
                selectedOptionAfterFirstPaint = UserDashboardUI.firstPaint(authController.authenticatedUser);
                String userName = authController.authenticatedUser.getUsername();
                switch (selectedOptionAfterFirstPaint){
                    case 1 :{
                        processStack.add("viewBookings");
                        ViewBookingController vController = ViewBookingController.getController(authController.authenticatedUser);
                        vController.runner();
                        processStack.pop();
                        break;
                    }
                    case 2:{
                        processStack.add("newTicket");
                        new TicketBookingController(userName).start();
                        processStack.pop();
                        break;
                    }
                    case 3:{
                        processStack.push("profile");
                        new UserProfileController(userName).startController();
                        processStack.pop();
                        break;
                    }
                    case 4:{
                        System.out.println("Logging out...");
                        authController.authenticatedUser=null;
                        processStack.clear();
                        // do not move forward this component: i.e go back to authentication.
                        return false;

                    }
                    default:{
                        System.out.println("SYSTEM: Select an appropriate option");
                        break;
                    }

                }
            }
        }

        processStack.push("firstPaint");
        //move forward : True
        return true;
    }
}
