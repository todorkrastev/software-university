package bg.softuni.java_oop.inheritance.exercises.P04_NeedForSpeed;

public class RaceMotorcycle extends Motorcycle {

    protected final static double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
