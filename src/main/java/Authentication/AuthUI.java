package Authentication;

import Authentication.AuthenticationServices.Services;
import Database.Entities.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AuthUI {


    // try to make an interface for this
    // MAYBE INTRODUCE HEAD AND TAIL FOR CAPTURING INPUTS
    public static int firstPaint(){
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("Authentication portal");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("");
        System.out.println("1) Sign IN");
        System.out.println("2) Sign UP");

        System.out.println("");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.print("Choose an option : ");
        Scanner sc = new Scanner(System.in);
        int option =0;
        try{
        option = sc.nextInt();
        }
        catch (InputMismatchException ignored){
        }

        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        return option;
    }

    public static User SignInPaint(){

        Scanner sc = new Scanner(System.in);

        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("Sign In");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("");

        //extract username
        System.out.print("Username : ");
        String username = sc.next();

        //extract password
        System.out.print("Password : ");
        String password = sc.next();
        System.out.println("");

        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");

        Services service = new Services();
        User user = service.SignIn(new User(username,password));
        if(user != null){
            System.out.print("System : sign in successful, Welcome "+ username +"\n");
            Stream.generate(() -> "=").limit(52).forEach(System.out::print);
            System.out.println("");
            return user;
        }
        else{
            System.out.print("System : sign in failed ! try again\n");
            Stream.generate(() -> "=").limit(52).forEach(System.out::print);
            System.out.println("");
            return null;
        }
    }

    public static User SignUpPaint(ArrayList<String> questions){

        Scanner sc = new Scanner(System.in);

        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("Sign up");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("");

        //extract email
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        System.out.print("Email : ");
        String email = sc.next();
        while (true){
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches()){
                break;
            }
            System.out.print("Email (should be in the form of : a@b.c): ");
            email = sc.next();
        }

        //extract username
        System.out.print("Username : ");
        String username = sc.next();

        //extract password
        System.out.print("Password : ");
        String password = sc.next();

        //extract confirm password
        System.out.print("Confirm Password : ");
        String confirmPassword = sc.next();
        while (true){

            if(password.equals(confirmPassword)){
                break;
            }
            System.out.print("Passwords does not match:Re enter \n");
            System.out.print("Password : ");
            password = sc.next();
            System.out.print("Confirm Password : ");
            confirmPassword = sc.next();
        }

        //extract security question
        System.out.print("Select a security question : ");
        for (int i =0;i<questions.size();i++){
            String ques = String.format("%d-> %s",i+1,questions.get(i));
            System.out.println( ques);
        }
        int securityQuestionOption = sc.nextInt();

        String securityQuestion = questions.get(securityQuestionOption-1);


        //extract answer
        System.out.print("Set an Answer : ");
        String answer = sc.next();

        System.out.println("");

        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");

        Services service = new Services();


        //user with encrypted password
        User addUser = new User(username,password);
        addUser.setSecurityQuestion(securityQuestion);
        addUser.setSecurityAnswer(answer);
        addUser.setEmail(email);

        //default role
        addUser.setRole("traveller");
        User user = service.SignUp(addUser);
        if(user != null){
            System.out.print("System : sign up successful, Welcome "+ username+"\n");
            Stream.generate(() -> "=").limit(52).forEach(System.out::print);
            System.out.println("");
            user.setSecurityAnswer(answer);
            user.setSecurityQuestion(securityQuestion);
            return user;
        }
        else{
            System.out.print("System : sign up failed ! try again\n");
            Stream.generate(() -> "=").limit(52).forEach(System.out::print);
            System.out.println("");
            return null;
        }
    }
}
