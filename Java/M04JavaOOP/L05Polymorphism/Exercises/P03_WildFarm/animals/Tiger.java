package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.animals;

import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Food;
import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Vegetable;

public class Tiger extends Felime{
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
