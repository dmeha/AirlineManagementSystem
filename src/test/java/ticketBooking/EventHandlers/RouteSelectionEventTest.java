package ticketBooking.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteSelectionEventTest {
    @Test
    public void RouteSelection(){
        Assertions.assertNotNull(new RouteSelectionEvent("USER1"));
    }

}