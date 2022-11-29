package ticketBooking.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteSelectionMenuTest {

    @Test
    public void RouteSelection(){
        Assertions.assertNotNull(new RouteSelectionMenu("USER1"));
    }

}