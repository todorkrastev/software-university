package entities;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    public static final String CAR_TYPE = "Car";

    private int kmCounter;

    public Car(int kmCounter) {
        super(CAR_TYPE, 300000);
        this.kmCounter = kmCounter;
    }

    public Car() {}

    public int getKmCounter() {
        return kmCounter;
    }

    public void setKmCounter(int kmCounter) {
        this.kmCounter = kmCounter;
    }
}