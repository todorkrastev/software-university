package bg.softuni.java_oop.interfaces_and_abstraction.lab.P06_Ferrari;

public class Ferrari implements Car {
    private final String driverName;
    private final String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = Car.MODEL;
    }

    public String getModel() {
        return this.model;
    }

    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.getModel(), this.brakes(), this.gas(), this.getDriverName());
    }
}
