package userProfile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProfileControllerTest {
    @Test
    public void HandleTest(){
        Assertions.assertNotNull(new UserProfileController("USER1"));

    }

}