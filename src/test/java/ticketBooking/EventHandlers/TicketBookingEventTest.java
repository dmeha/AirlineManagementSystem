package ticketBooking.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketBookingEventTest {
    @Test
    public void TicketBooking(){
        Assertions.assertNotNull(new TicketBookingEvent("USER1"));
    }

}