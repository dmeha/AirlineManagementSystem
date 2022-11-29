package Transactions.Records;

public record transactionRecordList(String transactionId, String amount, String user, String cardNo) {

    public transactionRecordList(String transactionId, String amount, String user, String cardNo) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.user = user;
        this.cardNo = cardNo;

    }
}
