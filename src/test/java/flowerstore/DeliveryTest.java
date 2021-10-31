package flowerstore;

import delivery.DHLDeliveryStrategy;
import delivery.PostDeliveryStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryTest {
    DHLDeliveryStrategy dhlDelivery;
    PostDeliveryStrategy postDelivery;
    Item item1 = new Flower(10, 15, new int[]{127, 0, 0}, FlowerType.TULIP);
    Item item2 = new Flower(16, 11, new int[]{127, 127, 0}, FlowerType.CHAMOMILE);
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
