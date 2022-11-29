package userProfile.DataLayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRewardTest {

    @Test
    public void Reward(){
        Assertions.assertNotNull(new UserReward("USER1"));
    }

}