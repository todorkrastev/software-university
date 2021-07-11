package bg.softuni.java_oop.polymorphism.exercises.P01_Vehicles;

public class Car extends Vehicle {

    private static final double AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION);
    }
}
