package Transactions.Controller.ViewAllTransactionDetails;

import Transactions.Controller.IController;
import Transactions.Model.TransactionRecord;
import Transactions.View.IMenu;
import Transactions.View.SpecificTransactionMenu;
import Transactions.Records.transactionRecordList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpecificTransactionController implements IController {
    public String userName;
    public int transactionId;
    public List<transactionRecordList> data;

    public SpecificTransactionController(String userName, int transactionId) {
        this.userName = userName;
        this.transactionId = transactionId;
    }

    @Override
    public void IController() {
        TransactionRecord record = new TransactionRecord(this.userName, this.transactionId);
        this.data = record.getTransactionRecord(Integer.toString(this.transactionId));


        IMenu transactionDetails = new SpecificTransactionMenu(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = transactionDetails.getMenu();

        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option));


    }

    @Override
    public void getSubMenu(int option) {


    }
}
