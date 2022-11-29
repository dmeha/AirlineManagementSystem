package ticketBooking.DataLayer;

import RouteFinder.dbOps.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment extends DAO {
    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Payment(){
        this.connection = getConnection();

    }

    public long execute(float price, String userName, String cardNo){
        String sqlStatement = "INSERT INTO `transaction` (`transactionAmount`, `transactionUser`, `transactionCard`) VALUES (?, ?, ?)";
        long transactionId=0;
        try {
            this.preparedStatement = this.connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setFloat(1, price);
            this.preparedStatement.setString(2, userName);
            this.preparedStatement.setString(3, cardNo);

            this.preparedStatement.executeUpdate();
            ResultSet resultSet = this.preparedStatement.getGeneratedKeys();
            resultSet.next();
            transactionId = resultSet.getLong(1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return transactionId;

    }

}
