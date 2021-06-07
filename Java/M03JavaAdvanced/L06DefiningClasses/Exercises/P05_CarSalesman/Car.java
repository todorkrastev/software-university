package bg.softuni.java_advanced.defining_classes.exercises.P05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    String getModel() {
        return model;
    }

    Engine getEngine() {
        return engine;
    }

    String getWeight() {
        return weight;
    }

    String getColor() {
        return color;
    }

    @Override
    public String toString() {
        Engine engine = this.getEngine();
        return String.format("%s:%n%s%nWeight: %s%nColor: %s", getModel(), engine.toString(), getWeight(), getColor());
    }
}
