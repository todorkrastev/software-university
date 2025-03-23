package solar.models;

public class Inverter {
    public String id;
    public int maxPvArraysConnected;

    public Inverter(String id, int maxPvArraysConnected) {
        this.id = id;
        this.maxPvArraysConnected = maxPvArraysConnected;
    }
}
