package bg.softuni.java_oop.encapsulation.exercises.P04_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    //+ 	Topping (String, double)
    private void setToppingType(String toppingType) {
        Validator.validateToppingType(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(weight, this.getToppingType());
        this.weight = weight;
    }

    private String getToppingType() {
        return this.toppingType;
    }

    public double calculateCalories() {
        return this.weight * 2 * this.getModifiersByToppingType(this.toppingType);
    }

    private double getModifiersByToppingType(String toppingType) {
        double result = 0.0;
        switch (toppingType) {
            case "Meat":
                return ToppingsModifier.MEAT.getToppingModifier();
            case "Veggies":
                return ToppingsModifier.VEGGIES.getToppingModifier();
            case "Cheese":
                return ToppingsModifier.CHEESE.getToppingModifier();
            case "Sauce":
                return ToppingsModifier.SAUCE.getToppingModifier();
        }
        return result;
    }
}
