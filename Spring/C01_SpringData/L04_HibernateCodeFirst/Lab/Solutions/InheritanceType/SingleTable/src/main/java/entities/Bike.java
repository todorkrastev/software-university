package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bike")
public class Bike extends Vehicle {
    private static final String BIKE_TYPE = "Bike";

    private int gearsCount;

    public Bike(int gearsCount) {
        super(BIKE_TYPE, 4000);
        this.gearsCount = gearsCount;
    }

    public Bike() {}

    public int getGearsCount() {
        return gearsCount;
    }

    public void setGearsCount(int gearsCount) {
        this.gearsCount = gearsCount;
    }
}
