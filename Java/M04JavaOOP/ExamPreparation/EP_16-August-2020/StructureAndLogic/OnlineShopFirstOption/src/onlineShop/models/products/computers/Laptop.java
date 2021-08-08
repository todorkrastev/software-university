package onlineShop.models.products.computers;

public class Laptop extends BaseComputer{

    private static final int DEFAULT_PERFORMANCE = 10;

    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DEFAULT_PERFORMANCE);
    }
}
