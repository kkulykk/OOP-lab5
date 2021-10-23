package flowerstore;

public enum FlowerType {
    ROSE, TULIP, CHAMOMILE;

    public static FlowerType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
