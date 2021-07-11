package bg.softuni.java_oop.polymorphism.exercises.P01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private final double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public String driving(double distance) {
        double fuelNeeded = getFuelConsumption() * distance;
        String output;
        if (fuelNeeded > getFuelQuantity()) {
            output = String.format("%s needs refueling", this.getClass().getSimpleName());
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            output = String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }
        return output;
    }

    public void refueling(double litres) {
        this.fuelQuantity += litres;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
