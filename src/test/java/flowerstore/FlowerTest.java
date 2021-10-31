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

class PaymentTest {
    PayPalPaymentStrategy paypal;
    CreditCardPaymentStrategy card;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        paypal = new PayPalPaymentStrategy();
        card = new CreditCardPaymentStrategy();
    }

    @org.junit.jupiter.api.Test
    void pay() {
        assertEquals("Payed with PayPal", paypal.pay(20));
        assertEquals("Payed with credit card", card.pay(20));
    }
}


class DeliveryTest {
    DHLDeliveryStrategy dhlDelivery;
    PostDeliveryStrategy postDelivery;
    Item item1 = new Flower(10, 15, new int[] {127,0,0}, FlowerType.TULIP );
    Item item2 = new Flower(16, 11, new int[] {127,127,0}, FlowerType.CHAMOMILE );
    List<Item> items = Arrays.asList(item1, item2);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        dhlDelivery = new DHLDeliveryStrategy();
        postDelivery = new PostDeliveryStrategy();
    }

    @org.junit.jupiter.api.Test
    void deliver() {
        assertEquals("The items would be delivered via DHL.", dhlDelivery.deliver(items));
        assertEquals("The items would be delivered via post.", postDelivery.deliver(items));
    }
}

class DecoratorTest {
    PaperDecorator paperDecorator;
    BasketDecorator basketDecorator;
    RibbonDecorator ribbonDecorator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Item item = new Flower(10, 15, new int[] {127,0,0}, FlowerType.TULIP );
        paperDecorator = new PaperDecorator(item);
        basketDecorator = new BasketDecorator(item);
        ribbonDecorator = new RibbonDecorator(item);
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
        assertEquals("This is TULIP flower.", basketDecorator.getDescription());
    }

    @org.junit.jupiter.api.Test
    void getPrice(){
        assertEquals(14, basketDecorator.getPrice());
        assertEquals(50, ribbonDecorator.getPrice());
        assertEquals(23, paperDecorator.getPrice());
    }

}