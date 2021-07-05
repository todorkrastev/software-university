package bg.softuni.java_oop.encapsulation.exercises.P04_PizzaCalories;

public class Validator {
    public static void validateFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void validateBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void validateDoughWeight(double doughWeight) {
        if (doughWeight < 1 || 200 < doughWeight) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void validateToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    public static void validateToppingWeight(double toppingWeight, String toppingType) {
        if (toppingWeight < 1 || 50 < toppingWeight) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
    }

    public static void validatePizzaName(String name) {
        if (name == null || name.trim().isEmpty() || 15 < name.length()) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void validateToppingNumber(int numberOfToppings) {
        if (numberOfToppings < 0 || 10 < numberOfToppings) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }


    private Validator() {
    }
}
