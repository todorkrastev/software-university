package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static final int DEFAULT_SIZE = 3;
    private static final int INCREASE_FISH_SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(DEFAULT_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + INCREASE_FISH_SIZE);
    }
}
