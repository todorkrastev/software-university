package restaurant.entities.tables;

public class Indoors extends BaseTable {
    private static final double CONSTANT_VALUE_PRICE_PER_PERSON = 3.5;

    public Indoors(int number, int size) {
        super(number, size, CONSTANT_VALUE_PRICE_PER_PERSON);
    }
}
