package userProfile.View;

import org.junit.jupiter.api.Test;

import userProfile.Records.UserTripsRecord;

import static org.junit.jupiter.api.Assertions.*;

class TripDetailMenuTest {

    @Test
    public void TripDetailMenu(){
        UserTripsRecord data = null;
        assertNotNull(new TripDetailMenu(data, "USER1"));
    }
}