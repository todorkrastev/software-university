package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.animals;

import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Food;
import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Meat;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }
}
