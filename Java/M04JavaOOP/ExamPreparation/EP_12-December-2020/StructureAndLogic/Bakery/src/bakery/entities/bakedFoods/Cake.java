package bakery.entities.bakedFoods;

public class Cake extends BaseFood {

    public static final double INITIAL_CAKE_PORTION = 245;

    public Cake(String name,double price) {

        super(name, INITIAL_CAKE_PORTION, price);
    }


}