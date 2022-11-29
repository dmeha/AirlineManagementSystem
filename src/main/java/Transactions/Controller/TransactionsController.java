package Transactions.Controller;

import Transactions.Controller.ViewAllTransactionDetails.TransactionDetailController;
import Transactions.View.IMenu;
import Transactions.View.TransactionsMenu;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TransactionsController implements IController {
    private String userName;
    public HashMap<String, String> data;
    ArrayList<String> formResponse;
    private Date date;
    public String flightNo;

    public TransactionsController(String userName) {
        this.userName = userName;
        this.data = new HashMap<>();
        this.date = new Date();
    }


    @Override
    public void IController() {
        IMenu transactions = new TransactionsMenu(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = transactions.getMenu();
        this.formResponse = userResp.get("formData");
        String option = userResp.get("option").get(0);
        this.getSubMenu(Integer.parseInt(option));


    }

    @Override
    public void getSubMenu(int option) {
        if (option == 0) {

        } else if (option == 1) {
            IController transactionController = new TransactionDetailController(this.userName, this.date);
            transactionController.IController();

        }
    }
}
