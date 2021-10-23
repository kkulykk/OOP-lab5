package flowerstore;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlowerPack {
    private Flower flower;
    private int amount;

    double getPrice() {
        return flower.getPrice() * amount;
    }
}
