package UserDashboard.ViewBookings;

import Database.Entities.User;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class ViewBookingUI {

    public static int firstPaint(User authenticatedUser){
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.printf("%s  total bookings 10 | kms flew 4.2km\n",authenticatedUser.getUsername());
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("");
        System.out.println("1) Trip 1");
        System.out.println("2) Trip 2");
        System.out.println("3) Trip 3");
        System.out.println("4) <-- Back");

        System.out.println("");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.print("Enter your option : ");
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

    //add booking class to display the details
    public static int bookingDetails(User authenticatedUser){

        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.printf("%s   | trip 1\n",authenticatedUser.getUsername());
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("");
        System.out.println("flight no : trip 1");
        System.out.println("origin : source airport");
        System.out.println("destination : target airport");
        System.out.println("date start : travel date");
        System.out.println("date end :travel end date");
        System.out.println("travellers : no of passengers");
        System.out.println("cost : total cost");
        System.out.println("");
        System.out.println("payment method : VISA");
        System.out.println("card : **** **** **** 4325");
        System.out.println("payment date : date of transaction");

        System.out.println("1) <-- Back");

        System.out.println("");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.print("Enter your option : ");
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

}
