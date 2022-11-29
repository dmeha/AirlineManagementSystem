package userProfile.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditProfileEventTest {

    @Test
    public void EditProfile(){
        Assertions.assertNotNull(new EditProfileEvent("USER1", null));
    }

}