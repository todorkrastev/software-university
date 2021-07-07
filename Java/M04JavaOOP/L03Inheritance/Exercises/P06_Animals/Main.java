package bg.softuni.java_oop.inheritance.exercises.P06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Animal> animals = new ArrayList<>();

        String animalType;
        while (!"Beast!".equals(animalType = reader.readLine())) {
            String[] animalInfo = reader.readLine().trim().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            Animal animal = null;
            try {
                switch (animalType) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                    default:
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (animal != null) {
                animals.add(animal);
            }
        }
        animals
                .forEach(System.out::println);
    }
}
