package Transactions.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Transactions.Records.transactionList;
public class TransactionList extends DAO{
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public TransactionList(){
        super();
        this.connection = getConnection();
    }
    public List<transactionList> getTransactionDetails(){
        String sqlStatement = "SELECT transactionId, transactionAmount, transactionUser, transactionCardNo from transaction";
        List<transactionList> data = new ArrayList<>();
        try{
            this.connection = getConnection();
            this.preparedStatement = this.connection.prepareStatement(sqlStatement);

            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                String transactionId = this.resultSet.getString("transactionId");
                String amount = this.resultSet.getString("transactionAmount");
                String user = this.resultSet.getString("transactionUser");
                String card= this.resultSet.getString("transactionCardNo");


                transactionList transaction = new transactionList(transactionId, amount, user, card);
                data.add(transaction);

            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }

}
