package bg.softuni.java_oop.polymorphism.exercises.P02_VehicleExtended;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private final double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
    }

    protected <T> T doWithIncreasedConsumption(double additionalConsumption, Supplier<T> supplier) {
        this.fuelConsumption += additionalConsumption;
        try {
            return supplier.get();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } finally {
            this.fuelConsumption -= additionalConsumption;
        }
    }

    // second option
 /*   protected void addConsumption(double additionalConsumption) {
        this.fuelConsumption += additionalConsumption;
    }

    protected void removeConsumption(double removelConsumption) {
        this.fuelConsumption -= removelConsumption;
    } */

    private void setFuelQuantity(double fuel) {
        validateNonNegativeFuelQuantity(fuel);
        validateHasEnoughFreeTankCapacity(fuel);
        this.fuelQuantity = fuel;
    }

    private void validateNonNegativeFuelQuantity(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void validateHasEnoughFreeTankCapacity(double additionalFuel) {
        if (additionalFuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    public String driving(double distance) {
        double fuelNeeded = fuelConsumption * distance;
        if (fuelNeeded > fuelQuantity) {
            return this
                    .getClass().getSimpleName() + " needs refueling";
        }
        this.setFuelQuantity(this.fuelQuantity - fuelNeeded);

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
    }

    public void refueling(double fuel) {
        validateNonNegativeFuelQuantity(fuel);
        validateHasEnoughFreeTankCapacity(fuel);
        setFuelQuantity(this.fuelQuantity + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
