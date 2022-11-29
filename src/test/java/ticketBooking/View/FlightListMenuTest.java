package ticketBooking.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightListMenuTest {
    @Test
    public void FlightList(){
        Assertions.assertNotNull(new FlightListMenu(null, "user1"));
    }

}