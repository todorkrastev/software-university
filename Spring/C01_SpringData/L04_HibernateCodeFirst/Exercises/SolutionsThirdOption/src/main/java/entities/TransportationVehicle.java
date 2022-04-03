package entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TransportationVehicle extends Vehicle{
    private int loadCapacity;

    public TransportationVehicle() {
    }

    public TransportationVehicle(String type, int loadCapacity, String ownerName) {
        super(type, ownerName);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
