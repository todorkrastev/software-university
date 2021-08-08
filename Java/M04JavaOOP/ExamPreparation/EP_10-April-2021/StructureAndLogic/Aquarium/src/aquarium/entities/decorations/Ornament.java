package aquarium.entities.decorations;

public class Ornament extends BaseDecoration {
    private static final int DEFAULT_COMFORT = 1;
    private static final double DEFAULT_PRICE = 5;

    public Ornament() {
        super(DEFAULT_COMFORT, DEFAULT_PRICE);
    }
}
