package Transactions.Model;

import java.util.HashMap;

public class TransactionCostRecord {


    public HashMap<String, String> getTotalTransactionCost(){
        HashMap<String, String> data = new HashMap<>();
        data.put("1 Passenger 1", "Transaction Amount: 100");
        data.put("2 Passenger 2", "Transaction Amount: 300");
        data.put("3 Passenger 3", "Transaction Amount: 750");


        return data;
    }

}
