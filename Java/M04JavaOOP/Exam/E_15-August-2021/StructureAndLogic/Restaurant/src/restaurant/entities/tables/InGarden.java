package restaurant.entities.tables;

public class InGarden extends BaseTable {
    private static final double CONSTANT_VALUE_PRICE_PER_PERSON = 4.5;

    public InGarden(int number, int size) {
        super(number, size, CONSTANT_VALUE_PRICE_PER_PERSON);
    }
}
