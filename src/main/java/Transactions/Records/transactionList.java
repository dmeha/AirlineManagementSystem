package Transactions.Records;

public record transactionList(String transactionId, String amount, String user, String cardNo) {



    public  transactionList(String transactionId, String amount, String user, String cardNo) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.user = user;
        this.cardNo = cardNo;


    }
}
