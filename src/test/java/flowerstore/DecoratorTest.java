package flowerstore;

import decorators.BasketDecorator;
import decorators.PaperDecorator;
import decorators.RibbonDecorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoratorTest {
    PaperDecorator paperDecorator;
    BasketDecorator basketDecorator;
    RibbonDecorator ribbonDecorator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Item item = new Flower(10, 15, new int[]{127, 0, 0}, FlowerType.TULIP);
        paperDecorator = new PaperDecorator(item);
        basketDecorator = new BasketDecorator(item);
        ribbonDecorator = new RibbonDecorator(item);
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
        assertEquals("This is TULIP flower.", basketDecorator.getDescription());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(14, basketDecorator.getPrice());
        assertEquals(50, ribbonDecorator.getPrice());
        assertEquals(23, paperDecorator.getPrice());
    }

}
