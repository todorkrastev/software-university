package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.animals;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        output.insert(output.indexOf(",") + 1, " " + this.breed + ",");

        return output.toString();
    }
}
