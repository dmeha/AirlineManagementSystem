package ticketBooking.View;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentGatewayMenuTest {

    @Test
    public void PaymentGateway(){
        Assertions.assertNotNull(new PaymentGatewayMenu("USER1"));
    }

}