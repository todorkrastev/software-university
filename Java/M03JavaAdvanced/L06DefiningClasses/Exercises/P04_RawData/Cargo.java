package bg.softuni.java_advanced.defining_classes.exercises.P04_RawData;

public class Cargo {
    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}
