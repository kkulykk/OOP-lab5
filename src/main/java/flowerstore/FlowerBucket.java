package flowerstore;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
public class FlowerBucket extends Item {
    @Getter
    List<FlowerPack> flowerPacks = new ArrayList<>();

    public void addFlowerPack(FlowerPack flowerPack) {
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

    @Override
    public String getDescription() {
        return("This is flower bucket of size "+getSize()+" and price "+getPrice()+".");
    }
}
