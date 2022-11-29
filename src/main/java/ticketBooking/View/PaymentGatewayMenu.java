package ticketBooking.View;

import java.util.*;

public class PaymentGatewayMenu implements Menu {
    private final String userName;
    final String line = "======================================================";
    public PaymentGatewayMenu(String userName){
        this.userName = userName;

    }

    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();

        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);

        Scanner inputCardNo = new Scanner(System.in);
        System.out.print("Enter Card No: ");
        String cardNo = inputCardNo.nextLine();

        Scanner inputExpiry = new Scanner(System.in);
        System.out.print("Enter Expiry: ");
        String expiry = inputExpiry.nextLine();

        Scanner inputCvv = new Scanner(System.in);
        System.out.print("Enter CVV: ");
        String cvv = inputCvv.nextLine();


        System.out.println("1. Proceed");
        System.out.println("0. Back to Main Menu");

        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        String option = userOption.nextLine();
        System.out.println(this.line);

        ArrayList<String> form = new ArrayList<>(Arrays.asList(cardNo, expiry, cvv));
        response.put("formData", form);
        response.put("option", new ArrayList<>(Collections.singleton(option)));
        return response;
    }
}
