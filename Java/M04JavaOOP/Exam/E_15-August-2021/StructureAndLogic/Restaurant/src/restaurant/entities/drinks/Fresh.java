package restaurant.entities.drinks;

public class Fresh extends BaseBeverage {
    private static final double CONSTANT_PRICE = 3.50;

    public Fresh(String name, int counter, String brand) {
        super(name, counter, CONSTANT_PRICE, brand);
    }
}
