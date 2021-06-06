package bg.softuni.java_advanced.defining_classes.exercises.P03_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKm, int traveledDistance) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.traveledDistance = traveledDistance;
    }

    public boolean drive(int kmDistance) {
        double fuelNeeded = kmDistance * this.fuelCostPerKm;
        if (fuelNeeded <= this.fuelAmount) {
            this.traveledDistance += kmDistance;
            this.fuelAmount -= fuelNeeded;
            return true;
        }
        return false;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public int getTraveledDistance() {
        return this.traveledDistance;
    }
}
