package userProfile.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import userProfile.View.TripDetailMenu;

import static org.junit.jupiter.api.Assertions.*;

class TripDetailEventTest {
    @Test
    public void TripDetail(){
        Assertions.assertNotNull(new TripDetailMenu(null, "USER1"));
    }

}