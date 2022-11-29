package userProfile.DataLayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTripsTest {
    @Test
    public void Trips(){
        Assertions.assertNotNull(new UserTrips("USER1"));
    }

}