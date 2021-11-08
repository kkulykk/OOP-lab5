package flowerstore;

import delivery.DHLDeliveryStrategy;
import org.junit.jupiter.api.Test;
import payment.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.*;

class QuickOrderTest {

    @Test
    void createOrder() {
        Order order = QuickOrder.CreateOrder(QuickOrder.ROSEORDER);
        assertEquals(order.orderSize(), 1);
        assertEquals(order.calculateTotalPrice(), 1000);
        assertInstanceOf(DHLDeliveryStrategy.class, order.getDelivery());
        assertInstanceOf(PayPalPaymentStrategy.class, order.getPayment());

    }

}