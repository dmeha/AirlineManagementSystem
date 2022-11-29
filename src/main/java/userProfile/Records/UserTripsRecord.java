package userProfile.Records;

import java.sql.Date;

public record UserTripsRecord(String departure, String destination, Date dateTravelled, int flightNo, float price) {
    public UserTripsRecord(String departure, String destination, Date dateTravelled, int flightNo, float price) {
        this.departure = departure;
        this.destination = destination;
        this.dateTravelled = dateTravelled;
        this.flightNo = flightNo;
        this.price = price;
    }
}
