package userProfile.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardDetailEventTest {
    @Test
    public void RewardDetail(){
        Assertions.assertNotNull(new RewardDetailEvent("USER1"));
    }

}