package ticketBooking.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FlightListEventTest {

    @Test
    public void FlightList(){
        ArrayList<String> data  = new ArrayList<>();
        data.add("arg1");
        data.add("arg2");
        data.add("arg3");
        Assertions.assertNotNull(new FlightListEvent("USER1", data));
    }

}