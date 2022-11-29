package ticketBooking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketBookingDAOTest {
    @Test
    public void TicketBooking(){
        Assertions.assertNotNull(new TicketBookingDAO());
    }

}