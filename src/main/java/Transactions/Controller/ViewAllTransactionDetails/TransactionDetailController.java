package Transactions.Controller.ViewAllTransactionDetails;

import Transactions.Controller.IController;
import Transactions.Model.TransactionList;
import Transactions.View.IMenu;
import Transactions.View.TransactionDetailsMenu;
import Transactions.Records.transactionList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TransactionDetailController implements IController {
    private String userName;
    public List<transactionList> data;
    public Date date;
    ArrayList<String> formResponse;

    public TransactionDetailController(String userName, Date date) {
        this.userName = userName;
        this.date = date;
    }

    @Override
    public void IController() {
        TransactionList list = new TransactionList();
        this.data = list.getTransactionDetails();

        Date date = new Date();
        IMenu edit = new TransactionDetailsMenu(this.data, this.userName, this.date);
        HashMap<String, ArrayList<String>> userResp = edit.getMenu();
        this.formResponse = userResp.get("formData");
        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option));

    }

    @Override
    public void getSubMenu(int option) {
        if(option == 0)
        {

        } else {
            SpecificTransactionController specificTransactionController = new SpecificTransactionController(this.userName, option);
            specificTransactionController.IController();
        }

    }
}
