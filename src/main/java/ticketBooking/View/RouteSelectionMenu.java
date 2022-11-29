package ticketBooking.View;

import java.util.*;

public class RouteSelectionMenu implements Menu {
    private final String userName;
    final String line = "======================================================";
    public RouteSelectionMenu(String userName){
        this.userName = userName;
    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);

        Scanner inputDeparture = new Scanner(System.in);
        System.out.print("Enter Departure Place: ");
        String departure = inputDeparture.nextLine();

        Scanner inputDestination = new Scanner(System.in);
        System.out.print("Enter Destination Place: ");
        String destination = inputDestination.nextLine();

        Scanner inputDateStart= new Scanner(System.in);
        System.out.print("Enter Date Start(YYYY-MM-DD): ");
        String dateStart = inputDateStart.nextLine();



        System.out.println("1. Proceed");
        System.out.println("Back to Main Menu");
        System.out.print("Enter your option: ");
        Scanner inputOption = new Scanner(System.in);
        String option = Integer.toString(inputOption.nextInt());

        ArrayList<String> form = new ArrayList<>(Arrays.asList(departure, destination, dateStart));

        response.put("formData", form);
        System.out.println(this.line);
        response.put("option", new ArrayList<String>(Collections.singleton(option)));

        return response;



    }
}
