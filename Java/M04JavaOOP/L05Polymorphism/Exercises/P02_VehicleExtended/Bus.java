package bg.softuni.java_oop.polymorphism.exercises.P02_VehicleExtended;

public class Bus extends Vehicle {

    private static final double AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String drivingWithPassengers(double distance) {
        return super.doWithIncreasedConsumption(AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION,
                () -> super.driving(distance));

        // second option
    /*    super.addConsumption(AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION);
        String output = super.driving(distance);
        super.removeConsumption(AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION);
        return output; */
    }
}
