package entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengersVehicle extends Vehicle{
    private int numOfPassengers;

    public PassengersVehicle() {
    }

    public PassengersVehicle(String type, int numOfPassengers, String ownerName) {
        super(type, ownerName);
        this.numOfPassengers = numOfPassengers;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}
