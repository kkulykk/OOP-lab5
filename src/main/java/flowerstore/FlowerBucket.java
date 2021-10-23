package flowerstore;


import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
public class FlowerBucket {
    List<FlowerPack> flowerPacks = new ArrayList<>();

    public void addFlower(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public int getSize() {
        return flowerPacks.size();
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }
}
