package userProfile.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import userProfile.Records.UserDetailRecord;

import static org.junit.jupiter.api.Assertions.*;

class UserProfileMenuTest {
    @Test
    public void UserProfile(){
        UserDetailRecord userDetailRecord = null;
        Assertions.assertNotNull(new UserProfileMenu(userDetailRecord, "USER1"));
    }

}