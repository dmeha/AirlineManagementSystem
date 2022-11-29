import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class WelcomeConsole{


    public static void printWelcomeConsole(){
        Scanner sc = new Scanner(System.in);
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.print("Welcome to Airline X\n");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("");
        System.out.println("-) This is an interactive console ");
        System.out.println("-) Which handles all the operations for Airline X ");

        System.out.println("");
        System.out.println("");
        Stream.generate(() -> "=").limit(52).forEach(System.out::print);
        System.out.println("");
        System.out.println("Press \"ENTER\" to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException ignored) {

        }
        System.out.println("");

        System.out.println("testing on development branch");



    }
}
