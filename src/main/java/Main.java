import flowerstore.Flower;
import flowerstore.FlowerType;
import flowerstore.Store;

import java.util.List;

public class Main {
    private static final Store newStore  = new Store();
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE STORE!\n");
        newStore.fillStore();
        newStore.search(500);
    }

}
