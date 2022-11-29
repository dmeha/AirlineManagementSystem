package Transactions.Controller;

import Transactions.Model.SpecificTransactionCost;
import Transactions.View.IMenu;
import Transactions.View.SpecificTransactionCostMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class SpecificTransactionCostController implements IController {
    public String userName;
    public String flightNo;
    public HashMap<String, String> data;

    public SpecificTransactionCostController(String userName, String flightNo) {
        this.userName = userName;
        this.flightNo = flightNo;
    }

    @Override
    public void IController() {
        SpecificTransactionCost costRecord = new SpecificTransactionCost(this.userName, this.flightNo);
        this.data = costRecord.getSpecificFlightCost();

        IMenu totalCost = new SpecificTransactionCostMenu(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = totalCost.getMenu();

        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option));

    }

    @Override
    public void getSubMenu(int option) {

    }
}
