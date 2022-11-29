package Transactions.Model;

import java.util.HashMap;

public class SpecificTransactionCost {
    public String userName;
    public String flightNo;

    public SpecificTransactionCost(String userName, String flightNo) {
        this.userName = userName;
        this.flightNo = flightNo;
    }

    public HashMap<String, String> getSpecificFlightCost() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Flight No.", "Flight1");
        data.put("Total Cost", "00000");
        data.put("Total Revenue", "00000");
        data.put("Source", "Start Location");
        data.put("Destination", "End Location");
        return data;
    }
}
