package flowerstore;

import delivery.DHLDeliveryStrategy;
import payment.PayPalPaymentStrategy;

public enum QuickOrder {
    ROSEORDER, TULIPORDER, CHAMOMILEORDER;

    public static Order CreateOrder(QuickOrder quickOrder) {
        Order order;
        FlowerBucket flowerBucket;
        FlowerPack flowerPack;
        Flower flower = null;

        if (quickOrder == ROSEORDER) {
            flower = new Flower(20, 15, new int[]{127, 127, 0}, FlowerType.ROSE);
        }
        if (quickOrder == TULIPORDER) {
            flower = new Flower(30, 10, new int[]{127, 0, 0}, FlowerType.TULIP);
        }
        if (quickOrder == CHAMOMILEORDER) {
            flower = new Flower(15, 15, new int[]{0, 127, 0}, FlowerType.CHAMOMILE);
        }

        flowerPack = new FlowerPack(flower, 50);
        flowerBucket = new FlowerBucket();
        flowerBucket.addFlowerPack(flowerPack);

        order = new Order();
        order.addItem(flowerBucket);
        order.setPaymentStrategy(new PayPalPaymentStrategy());
        order.setDeliveryStrategy(new DHLDeliveryStrategy());

        return order;

    }

}
