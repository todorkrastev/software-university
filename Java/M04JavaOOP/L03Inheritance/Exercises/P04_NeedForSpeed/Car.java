package bg.softuni.java_oop.inheritance.exercises.P04_NeedForSpeed;

public class Car extends Vehicle {

    protected final static double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
