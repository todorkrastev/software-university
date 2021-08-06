package bakery.entities.tables;

public class OutsideTable extends BaseTable {

    public static final double PRICE_PER_PERSON  = 3.50;

    public OutsideTable(int tableNumber, int capacity) {

        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}