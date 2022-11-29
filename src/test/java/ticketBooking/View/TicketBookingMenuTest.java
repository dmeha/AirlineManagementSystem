package ticketBooking.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketBookingMenuTest {

    @Test
    public void TicketBooking(){
        Assertions.assertNotNull(new TicketBookingMenu("USER1"));
    }

}