package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Car extends PassengersVehicle{
    private String model;

    public Car() {
    }

    public Car(int numOfPassengers, String model, String ownerName) {
        super("CAR", numOfPassengers, ownerName);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
