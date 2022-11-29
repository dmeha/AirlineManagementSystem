package userProfile.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RewardDetailMenuTest {
    @Test
    public void RewardDetail(){
        HashMap<String, String > data = new HashMap<>();
        Assertions.assertNotNull(new RewardDetailMenu(data, "USER1"));
    }

}