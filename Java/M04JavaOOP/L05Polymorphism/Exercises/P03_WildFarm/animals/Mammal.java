package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.animals;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
}
