package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium{
    private static final int DEFAULT_CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, DEFAULT_CAPACITY);
    }

    @Override
    public String getInfo() {
        return String.format("%s (%s):", super.getName(), this.getClass().getSimpleName()) +
                System.lineSeparator() +
                super.getInfo();
    }
}
