package userProfile.Records;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTripsRecordTest {
    @Test
    public void UserTrips(){
        Date date = null;
        Assertions.assertNotNull(

                new UserTripsRecord("Halifax", "Montreal", date, 1 ,200)
        );
    }

}