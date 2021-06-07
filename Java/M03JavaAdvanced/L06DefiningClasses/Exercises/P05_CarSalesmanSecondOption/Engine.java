package bg.softuni.java_advanced.defining_classes.exercises.P05_CarSalesmanSecondOption;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.model);
        stringBuilder.append(":")
                .append(System.lineSeparator());
        stringBuilder.append("Power: ")
                .append(this.power)
                .append(System.lineSeparator());
        stringBuilder.append("Displacement: ")
                .append(this.displacement == 0 ? "n/a" : this.displacement)
                .append(System.lineSeparator());
        stringBuilder.append("Efficiency: ")
                .append(this.efficiency)
                .append(System.lineSeparator());
        return stringBuilder.toString().trim();
    }
}
