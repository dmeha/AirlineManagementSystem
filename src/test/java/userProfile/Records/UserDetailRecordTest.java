package userProfile.Records;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class UserDetailRecordTest {
    

    @Test
    public void UserDetails() {
        Assertions.assertNotNull(
                new UserDetailRecord("1", "test@email.com", "testName", "Test Address", "123456789")

        );
    }

}