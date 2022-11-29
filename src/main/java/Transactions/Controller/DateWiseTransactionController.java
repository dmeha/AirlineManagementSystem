package Transactions.Controller;

import Transactions.View.DateWiseTransactionMenu;
import Transactions.View.IMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class DateWiseTransactionController implements IController {
    private String userName;
    public HashMap<String, String> data;
    ArrayList<String> formResponse;

    public DateWiseTransactionController(String userName) {
        this.userName = userName;
    }


    @Override
    public void IController() {
        IMenu transactionDetails = new DateWiseTransactionMenu(this.data, this.userName);
        HashMap<String, ArrayList<String>> userResp = transactionDetails.getMenu();
        this.formResponse = userResp.get("formData");


    }

    @Override
    public void getSubMenu(int option) {

    }
}
