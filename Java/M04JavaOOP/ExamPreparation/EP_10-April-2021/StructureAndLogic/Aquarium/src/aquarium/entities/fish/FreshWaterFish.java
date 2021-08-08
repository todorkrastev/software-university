package aquarium.entities.fish;

public class FreshWaterFish extends BaseFish {
    private static final int DEFAULT_SIZE = 3;
    private static final int DEFAULT_INCREASE_SIZE = 3;

    public FreshWaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(DEFAULT_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + DEFAULT_INCREASE_SIZE);
    }
}
