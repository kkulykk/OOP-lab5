package flowerstore;

import decorators.BasketDecorator;
import decorators.PaperDecorator;
import decorators.RibbonDecorator;
import delivery.DHLDeliveryStrategy;
import delivery.PostDeliveryStrategy;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private Flower flower;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.CHAMOMILE);
        flower.setPrice(10);
        flower.setSepalLength(15);
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(10, flower.getPrice());
    }

    @org.junit.jupiter.api.Test
    void getFlowerType() {
        assertEquals(FlowerType.CHAMOMILE, flower.getFlowerType());
    }

   @org.junit.jupiter.api.Test
    void getSepalLength() {
        assertEquals(15, flower.getSepalLength());
    }
}


