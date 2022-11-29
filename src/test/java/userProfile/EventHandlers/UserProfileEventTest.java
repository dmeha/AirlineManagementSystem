package userProfile.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProfileEventTest {

    @Test
    public void UserProfile(){
        Assertions.assertNotNull(new UserProfileEvent("USER1"));
    }

}