package ticketBooking.DataLayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTicketTest {

    @Test
    public void BookTicket(){
        Assertions.assertNotNull(new BookTicket());
    }

}