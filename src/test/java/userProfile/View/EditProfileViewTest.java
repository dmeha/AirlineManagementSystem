package userProfile.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import userProfile.Records.UserDetailRecord;

import static org.junit.jupiter.api.Assertions.*;

class EditProfileViewTest {


    @Test
    public void EditProfileTest(){
        UserDetailRecord userDetailRecord = null;
        Assertions.assertNotNull(new EditProfileView(userDetailRecord, "USER1"));
    }

}