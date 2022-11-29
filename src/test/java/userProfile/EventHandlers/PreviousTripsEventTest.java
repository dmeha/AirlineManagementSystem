package userProfile.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreviousTripsEventTest {

    @Test
    public void PreviousTrips(){
        Assertions.assertNotNull(new PreviousTripsEvent("user1"));
    }

}