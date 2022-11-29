package ticketBooking.Records;

public record RouteSelectionRecord(String departure, String destination, String startDate) {
    public RouteSelectionRecord(String departure, String destination, String startDate){
        this.departure = departure;
        this.destination = destination;
        this.startDate = startDate;
    }
}
