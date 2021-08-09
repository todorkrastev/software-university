package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    private static final int DEFAULT_CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, DEFAULT_CAPACITY);
    }
}
