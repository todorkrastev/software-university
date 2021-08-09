package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    private static final int DEFAULT_SIZE = 5;
    private static final int DEFAULT_INCREASE_SIZE = 2;


    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(DEFAULT_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + DEFAULT_INCREASE_SIZE);
    }
}
