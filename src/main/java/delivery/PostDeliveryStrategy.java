package delivery;

import flowerstore.Item;

import java.util.List;

public class PostDeliveryStrategy implements Delivery{
    @Override
    public String deliver(List<Item> items) {
        System.out.println("The items would be delivered via post.");
        return ("The items would be delivered via post.");
    }
}
