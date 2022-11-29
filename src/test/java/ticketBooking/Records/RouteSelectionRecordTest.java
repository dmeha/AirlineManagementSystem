package ticketBooking.Records;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteSelectionRecordTest {
    @Test
    public void RouteSelectionRecord(){
        Assertions.assertNotNull(new RouteSelectionRecord(null, null, null));
    }

}