

import Authentication.AuthController;
import Database.Entities.User;
import UserDashboard.UserDashboardController;


import java.util.Stack;
//import Authentication.Services;
import StaffHandling.Controller.IController;
import StaffHandling.Controller.StaffHandlingController;

import ticketBooking.TicketBookingController;

import adminDashboard.adminDashboardMenu;

public class AMS{

    public static void main(String[] args) {

        Stack<String> aplphaProcessStack = new Stack<String>(){
            {
                push("welcome");
            }
        };

        //mock authenticated user
        User user = new User("dev","dev'sStrongPasswrod");
        user.setSecurityAnswer("answer");
        user.setSecurityQuestion("dummy security question");
        user.setEmail("dev@email.com");
        user.setId(1);

        //mocking user role
        String Role = "admin";

        //authenticated user
        User authenticatedUser=null;

        AuthController authController = AuthController.getController();

        while(!aplphaProcessStack.empty()){
//            System.out.println("currently :"+aplphaProcessStack.peek());
            switch (aplphaProcessStack.peek()){

                case "welcome":{
                    WelcomeConsole.printWelcomeConsole();
                    aplphaProcessStack.push("authentication");
                    break;

                }
                case "authentication":{

                    authController.runner();
                    authenticatedUser = authController.authenticatedUser;
//                    System.out.println(authenticatedUser);
                    switch (authenticatedUser.getRole()){
                        case "traveller":{
                            aplphaProcessStack.push("userdashboard");
                            break;
                        }

                        case "admin":{
                            aplphaProcessStack.push("admindashboard");
                            break;
                        }
                    }
                    break;
                }
                case "userdashboard":{
                    UserDashboardController userDashController = UserDashboardController.getController(authController);
                    boolean forward = userDashController.runner();
                    if(!forward ){
                        aplphaProcessStack.pop();
                        break;
                    }
                    break;
                }

                case "admindashboard":{

                    adminDashboardMenu adminDashboardMenu = adminDashboard.adminDashboardMenu.getController(authController);
                    boolean forward = adminDashboardMenu.runner();
                    if(!forward ){
                        aplphaProcessStack.pop();
                        break;
                    }
                    break;
                }
            }

        }

    }
}




