package Transactions.View;

import java.util.*;
import Transactions.Records.transactionList;

public class TransactionDetailsMenu implements IMenu {
    private final List<transactionList> data;
    private final String userName;
    final String line = "======================================================";
    private Date date;

    public TransactionDetailsMenu(List<transactionList> data, String userName, Date date) {
        this.data = data;
        this.userName = userName;
        this.date = date;
    }


    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        Date date = new Date();
        System.out.println(this.line);
        System.out.println(this.userName + "\t\t" + this.date);
        System.out.println(this.line);
        this.data.forEach(transaction -> {
            System.out.println("Transaction id: "+ transaction.transactionId());

        });
        System.out.println("Enter Transaction Id for more details");
        System.out.println("0. Back to Menu");
        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = userOption.nextInt();
        System.out.println(this.line);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;

    }
}
