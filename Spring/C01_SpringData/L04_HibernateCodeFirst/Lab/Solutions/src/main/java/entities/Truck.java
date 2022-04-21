package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trucs")
public class Truck extends TransportationVehicle{
    private int numOfContainers;

    public Truck() {
    }

    public Truck(int loadCapacity, int numOfContainers, String ownerName) {
        super("TRUCK", loadCapacity, ownerName);
        this.numOfContainers = numOfContainers;
    }

    public int getNumOfContainers() {
        return numOfContainers;
    }

    public void setNumOfContainers(int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }
}
