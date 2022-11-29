package userProfile.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import userProfile.Records.UserTripsRecord;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreviousTripsMenuTest {

    @Test
    public void PreviousTrips(){
        List<UserTripsRecord> userTripsRecords = new ArrayList<>();
        Assertions.assertNotNull(new PreviousTripsMenu(userTripsRecords, "USER1"));
    }

}