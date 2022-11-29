package RouteFinder.dbOps;

import RouteFinder.Flight;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListFlights extends DAO{
    private  Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ListFlights(){
        super();

    }

    public List<Flight> getData(String Departure, String startDate){
        HashMap<String, HashMap<String, String>> data = new HashMap<>();
        List<Flight> flights = new ArrayList<>();

        String sqlStatement = "SELECT * " +
                "FROM flight " +
                "LEFT JOIN routes ON flight.routeId = routes.routeId WHERE routes.departure= ? and takeoffTime >= ?";
        try{
           this.connection = getConnection();
           this.preparedStatement = this.connection.prepareStatement(sqlStatement);
           this.preparedStatement.setString(1, Departure);
            this.preparedStatement.setString(2, startDate);
           this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                int flightId = this.resultSet.getInt("flightId");
                String destination = this.resultSet.getString("destination");
                String departure = this.resultSet.getString("departure");
                float price = this.resultSet.getFloat("routePrice");
                int capacity = this.resultSet.getInt("capacity");
                Timestamp takeoffTime = this.resultSet.getTimestamp("takeoffTime");
                Timestamp landingTime = this.resultSet.getTimestamp("landingTime");
                Flight flight = new Flight(flightId, departure, destination, capacity, takeoffTime, landingTime, price);

                flights.add(flight);

           }

        } catch (Exception e){
            e.printStackTrace();
        }
        return flights;
    }
}
