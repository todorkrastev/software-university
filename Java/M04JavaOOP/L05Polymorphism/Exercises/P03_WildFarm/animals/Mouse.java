package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.animals;

import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Food;
import bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods.Meat;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }
}
