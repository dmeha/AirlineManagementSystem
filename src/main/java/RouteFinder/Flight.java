package RouteFinder;

import java.sql.Date;
import java.sql.Timestamp;

public record Flight(int flightNumber, String departure, String destination, int capacity, Timestamp takeOffTime, Timestamp landingTime, float price) {

    public Flight(int flightNumber, String departure, String destination, int capacity, Timestamp takeOffTime, Timestamp landingTime, float price) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.capacity = capacity;
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
        this.price = price;
    }
}

