package flowerstore;

import java.util.*;
import java.util.HashMap;
import java.util.Map;


public class Store {

    List<Flower> Storage = new ArrayList<>();

    Map<FlowerType, Integer> prices = new HashMap<FlowerType, Integer>() {{
        put(FlowerType.CHAMOMILE, 10);
        put(FlowerType.ROSE, 25);
        put(FlowerType.TULIP, 18);
    }};

    Random random = new Random();

    public void fillStore() {
        for (int i = 0; i < 100; i++) {

            Flower randomFlower = new Flower(FlowerType.getRandom());
            randomFlower.setPrice(prices.get(randomFlower.getFlowerType()));
            randomFlower.setColor(new int[]{random.nextInt(127), random.nextInt(127), random.nextInt(127)});
            randomFlower.setSepalLength(random.nextInt(50));
            Storage.add(randomFlower);
        }
    }


    public void search(int sumGiven) {
        FlowerBucket oneFlowerBucket = new FlowerBucket();

        int totalSum = 0;
        int tulipsAmount = 0;
        int rosesAmount = 0;
        int chamomilesAmount = 0;

        while (sumGiven > oneFlowerBucket.getPrice()) {
            int flowerIndex = random.nextInt(Storage.size());
            Flower chosenFlower = Storage.get(flowerIndex);
            totalSum += chosenFlower.getPrice();
            if (chosenFlower.getFlowerType() == FlowerType.CHAMOMILE) {
                chamomilesAmount += 1;
            } else if (chosenFlower.getFlowerType() == FlowerType.ROSE) {
                rosesAmount += 1;
            } else if (chosenFlower.getFlowerType() == FlowerType.TULIP) {
                tulipsAmount += 1;
            }
            FlowerPack oneFlowerPack = new FlowerPack(chosenFlower, 1);
            oneFlowerBucket.addFlowerPack(oneFlowerPack);
            Storage.remove(flowerIndex);
        }
        System.out.println("We formed your bucket for the price "+totalSum+".\nWe propose you to buy "+chamomilesAmount+" chamomiles, "+rosesAmount+" roses and "+tulipsAmount+" tulips.");
    }
}

