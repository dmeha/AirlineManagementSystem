package userProfile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    @Test
    public void DaoTest(){
        Assertions.assertNotNull(new UserDAO());
    }

}