package bg.softuni.java_oop.polymorphism.exercises.P01_Vehicles;

public class Truck extends Vehicle{

    private static final double AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 1.6;
    private static final double REDUCE_REFUEL = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION);
    }

    @Override
    public void refueling(double litres) {
        super.refueling(litres * REDUCE_REFUEL);
    }
}
