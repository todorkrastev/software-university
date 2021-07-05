package bg.softuni.java_oop.encapsulation.exercises.P04_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        Validator.validateDoughWeight(weight);
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        Validator.validateFlourType(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validator.validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    //+	calculateCalories (): double
    public double calculateCalories() {
        return this.weight * 2 * getModifiersByFlourType(this.flourType) * getModifiersByBakingTechnique(this.bakingTechnique);
    }

    private double getModifiersByFlourType(String flourType) {
        double result = 0.0;
        switch (flourType) {
            case "White":
                return DoughModifiers.WHITE.getDoughModifier();
            case "Wholegrain":
                return DoughModifiers.WHOLEGRAIN.getDoughModifier();
        }
        return result;
    }

    private double getModifiersByBakingTechnique(String bakingTechnique) {
        double result = 0.0;
        switch (bakingTechnique) {
            case "Crispy":
                return DoughModifiers.CRISPY.getDoughModifier();
            case "Chewy":
                return DoughModifiers.CHEWY.getDoughModifier();
            case "Homemade":
                return DoughModifiers.HOMEMADE.getDoughModifier();
        }
        return result;
    }
}
