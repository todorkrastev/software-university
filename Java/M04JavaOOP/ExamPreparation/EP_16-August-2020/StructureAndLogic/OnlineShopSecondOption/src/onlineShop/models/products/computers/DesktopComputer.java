package onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer{

    private static final int DEFAULT_OVERALL = 15;

    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, DEFAULT_OVERALL);
    }
}
