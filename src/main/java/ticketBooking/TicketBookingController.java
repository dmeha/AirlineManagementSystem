package ticketBooking;
import ticketBooking.EventHandlers.Event;
import ticketBooking.EventHandlers.TicketBookingEvent;
public class TicketBookingController {
    private String userName;
    Event ticketBooking;
    public TicketBookingController(String userName){
        this.userName = userName;
        this.ticketBooking = new TicketBookingEvent(this.userName);
    }


    public void start(){
        while(this.ticketBooking != null){

            ticketBooking = this.ticketBooking.handle();
        }

    }

}
