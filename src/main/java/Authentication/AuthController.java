package Authentication;

import Authentication.AuthenticationServices.AuthService;
import Authentication.AuthenticationServices.Services;
import Database.Entities.User;

import java.util.ArrayList;

public class AuthController {

    private static AuthController authController;

    AuthService services;

    //initialize it with first trigger
    private static final ArrayList<String> processStack = new ArrayList<String>(){
        {
            add("firstPaint");
        }
    };


    public  User authenticatedUser = null;


    private AuthController(){
    services = new Services();
    }


    public static AuthController getController(){
        if(authController == null){
            authController = new AuthController();
        }
        return authController;
    }

    private static final ArrayList<String> questions = new ArrayList<String>() {
        {
            add("In what city were you born?");
            add("What is the name of your favorite pet?");
            add("What is your mothers maiden name?");
            add("What high school did you attend?");
            add("What is your mothers maiden name?");
            add("What is the name of your first school?");
            add("What was the make of your first car?");
            add("What was your favorite food as a child?");
            add("Where did you meet your spouse?");
        }
    };



    public void logoffUser(){
        authenticatedUser=null;
    }

    public  boolean runner(){

        while(!processStack.isEmpty()){

            //first paint
            int selectedOptionAfterFirstPaint;
            if(processStack.get(processStack.size()-1).equals("firstPaint")){
                selectedOptionAfterFirstPaint = AuthUI.firstPaint();

                switch (selectedOptionAfterFirstPaint){
                    case 1 :{
                        processStack.add("SignIn");
                        authenticatedUser = AuthUI.SignInPaint();
                        break;
                    }
                    case 2:{
                        processStack.add("SignUp");
                        authenticatedUser = AuthUI.SignUpPaint(questions);
                        break;
                    }
                    default:{
//                        authenticatedUser = null;
                        System.out.println("SYSTEM: Select an appropriate option");
                        break;
                    }

                }
            }

//            //sign in paint
//            if(processStack.get(processStack.size()-1).equals("SignIn")){
//                authenticatedUser = AuthUI.SignInPaint();
//            }
//
//            //sign Up paint
//            if(processStack.get(processStack.size()-1).equals("SignUp")){
//                authenticatedUser = AuthUI.SignUpPaint(questions);
//
//            }

            if(authenticatedUser != null){
                processStack.clear();
            }

        }
        //trick to initialize for later purpose
        processStack.add("firstPaint");
        return false;



    }


}
