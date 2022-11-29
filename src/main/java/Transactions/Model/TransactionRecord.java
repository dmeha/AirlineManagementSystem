package Transactions.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Transactions.Records.transactionRecordList;


public class TransactionRecord extends DAO{
    public String userName;
    public int option;
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private List<transactionRecordList> data;

    public TransactionRecord(String userName, int transaction) {
        super();
        this.userName = userName;
        this.option = transaction;
        this.connection = getConnection();
    }

    public List<transactionRecordList> getTransactionRecord(String transactionId) {
        String sqlStatement = "SELECT transactionId, transactionAmount, transactionUser, transactionCardNo from transaction WHERE transactionId=?";
        this.data = new ArrayList<>();
        try {
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, transactionId);
            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){

                String amount = this.resultSet.getString("transactionAmount");
                String user = this.resultSet.getString("transactionUser");
                String cardNo = this.resultSet.getString("transactionCardNo");
                transactionRecordList transaction = new transactionRecordList(transactionId, amount, user, cardNo);
                data.add(transaction);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }


}
