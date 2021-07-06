package bg.softuni.java_oop.inheritance.exercises.P04_NeedForSpeed;

public class SportCar extends Car {
    protected final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
