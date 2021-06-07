package bg.softuni.java_advanced.defining_classes.exercises.P05_CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    String getModel() {
        return model;
    }

    String getPower() {
        return power;
    }

    String getDisplacement() {
        return displacement;
    }

    String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s", getModel(), getPower(), getDisplacement(), getEfficiency());
    }
}
