package Transactions.View;

import java.util.*;

import Transactions.Records.transactionRecordList;
public class SpecificTransactionMenu implements IMenu {
    private List<transactionRecordList> data;

    private String userName;
    final String line = "======================================================";

    public SpecificTransactionMenu(List<transactionRecordList> data, String userName) {
        this.data = data;
        this.userName = userName;
    }


    @Override
    public HashMap<String, ArrayList<String>> getMenu() {
        HashMap<String, ArrayList<String>> response = new HashMap<>();
        System.out.println(this.line);
        System.out.println(this.userName);
        System.out.println(this.line);
        this.data.forEach(transaction-> {
            System.out.println("transaction Id: "+ transaction.transactionId() );
            System.out.println("Amount: "+ transaction.amount());
            System.out.println("User : " + transaction.user());
            System.out.println("Card No: "+ transaction.cardNo());

        });
        System.out.println("0.Back to Main Menu");
        Scanner inputOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        int option = inputOption.nextInt();
        System.out.println(this.line);
        response.put("option", new ArrayList<String>(Collections.singleton(Integer.toString(option))));
        return response;


    }
}
