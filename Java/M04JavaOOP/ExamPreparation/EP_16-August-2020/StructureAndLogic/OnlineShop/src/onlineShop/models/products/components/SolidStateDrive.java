package onlineShop.models.products.components;

public class SolidStateDrive extends BaseComponent {

    private static final double DEFAULT_MULTIPLIER = 1.20;

    public SolidStateDrive(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, DEFAULT_MULTIPLIER * overallPerformance, generation);
    }
}
