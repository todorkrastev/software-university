package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.animals;

import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.animalType,
                this.animalName,
                decimalFormat.format(this.animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}
