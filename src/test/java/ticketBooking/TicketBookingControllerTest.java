package ticketBooking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketBookingControllerTest {

    @Test
    public void TicketBookingController(){
        Assertions.assertNotNull(new TicketBookingController("USER1"));
    }

}