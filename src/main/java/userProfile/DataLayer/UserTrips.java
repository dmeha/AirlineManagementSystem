package userProfile.DataLayer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

import userProfile.Records.UserTripsRecord;
import userProfile.UserDAO;

public class UserTrips extends UserDAO {
    private final String userName;
    private final Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public UserTrips(String userName) {

        super();
        this.userName = userName;
        this.connection = getConnection();
    }


    // Fetch User Trip details
    public List<UserTripsRecord> getData() {

        List<UserTripsRecord> data = new ArrayList<>();

        try {
            String sqlStatement = "SELECT * " +
                    "FROM flight tf " +
                    "JOIN TicketBooking tb ON tf.flightId = tb.ticketFlight " +
                    "JOIN routes tr ON tf.routeId = tr.routeId " +
                    "WHERE tb.tickerUser = ?";

            this.preparedStatement = this.connection.prepareStatement(sqlStatement);
            this.preparedStatement.setString(1, this.userName);

            this.resultSet = this.ExecuteSelect(preparedStatement);

            while (this.resultSet.next()) {
                String departure = this.resultSet.getString("departure");
                String destination = this.resultSet.getString("destination");
                Date dateTravelled = this.resultSet.getDate("takeoffTime");
                int flightNo = this.resultSet.getInt("flightId");
                float price = this.resultSet.getFloat("routePrice");
                data.add(new UserTripsRecord(departure, destination, dateTravelled, flightNo, price));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

