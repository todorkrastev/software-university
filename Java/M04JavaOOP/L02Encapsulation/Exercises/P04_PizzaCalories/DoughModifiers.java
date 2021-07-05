package bg.softuni.java_oop.encapsulation.exercises.P04_PizzaCalories;

public enum DoughModifiers {
    WHITE(1.5),
    WHOLEGRAIN(1.0),
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);

    private final double doughModifier;

    DoughModifiers(double doughModifier) {
        this.doughModifier = doughModifier;
    }

    public double getDoughModifier() {
        return this.doughModifier;
    }
}
