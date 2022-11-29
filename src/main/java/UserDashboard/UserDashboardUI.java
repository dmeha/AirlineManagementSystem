package UserDashboard;

import Database.Entities.User;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class UserDashboardUI {

    public static int firstPaint(User authenticatedUser){
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.printf("Hey,%s  (role=)\n",authenticatedUser.getUsername());
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("");
        System.out.println("1) View your bookings");
        System.out.println("2) Purchase new ticker");
        System.out.println("3) Your profile");
        System.out.println("4) Log off");

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


}
