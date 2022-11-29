package ticketBooking.DataLayer;

import ticketBooking.TicketBookingDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookTicket extends TicketBookingDAO {

    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public BookTicket(){
        super();
        this.connection = getConnection();
    }

    public void book(String userName, int flightId , long transactionId) {
        String sqlStatement = "INSERT INTO `ticketBooking` (`tickerUser`, `ticketFlight`, `ticketTransaction`) VALUES (?, ?, ?)";
        try {

            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, userName);
            this.preparedStatement.setInt(2, flightId);
            this.preparedStatement.setLong(3, transactionId);
            this.ExecuteInsert(preparedStatement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
