package userProfile.DataLayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDataTest {

    @Test
    public void UserData(){
        Assertions.assertNotNull(new UserData("USER1"));
    }
}