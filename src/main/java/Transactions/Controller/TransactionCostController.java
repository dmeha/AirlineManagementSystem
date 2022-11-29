package Transactions.Controller;

import Transactions.Model.TransactionCostRecord;
import Transactions.View.IMenu;
import Transactions.View.TransactionCostMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class TransactionCostController implements IController {
    private String userName;
    public String flightNo;
    public HashMap<String, String> data;
    ArrayList<String> formResponse;

    public TransactionCostController(String userName, String flightNo) {
        this.userName = userName;
        this.flightNo = flightNo;
    }


    @Override
    public void IController() {
        TransactionCostRecord record = new TransactionCostRecord();
        this.data = record.getTotalTransactionCost();
        IMenu totalCost = new TransactionCostMenu(this.data, this.userName, this.flightNo);
        HashMap<String, ArrayList<String>> userResp = totalCost.getMenu();
        this.formResponse = userResp.get("formData");
        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option));

    }

    @Override
    public void getSubMenu(int option) {
        if (option == 0) {

        } else {
            SpecificTransactionCostController costController = new SpecificTransactionCostController(this.userName, this.flightNo);
            costController.IController();
        }
    }
}
