package ticketBooking.EventHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ticketBooking.View.PaymentGatewayMenu;

import static org.junit.jupiter.api.Assertions.*;

class PaymentGatewayEventTest {

    @Test
    public void PaymentGateway(){
        Assertions.assertNotNull(new PaymentGatewayMenu("USER1"));
    }

}