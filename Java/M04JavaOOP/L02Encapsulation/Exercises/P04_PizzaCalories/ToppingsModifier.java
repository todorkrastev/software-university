package bg.softuni.java_oop.encapsulation.exercises.P04_PizzaCalories;

public enum ToppingsModifier {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private final double toppingModifier;

    ToppingsModifier(double toppingModifier) {
        this.toppingModifier = toppingModifier;
    }

    public double getToppingModifier() {
        return this.toppingModifier;
    }
}
