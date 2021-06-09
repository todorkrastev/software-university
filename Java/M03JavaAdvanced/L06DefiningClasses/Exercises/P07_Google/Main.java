package bg.softuni.java_advanced.defining_classes.exercises.P07_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Person> peopleMap = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String name = tokens[0];
            String command = tokens[1];

            peopleMap.putIfAbsent(name, new Person());

            switch (command) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);

                    peopleMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    peopleMap.get(name).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parents parent = new Parents(parentName, parentBirthday);

                    peopleMap.get(name).getParentsList().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Children child = new Children(childName, childBirthday);

                    peopleMap.get(name).getChildrenList().add(child);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);

                    peopleMap.get(name).setCar(car);
                    break;
                default:
                    break;
            }
        }
        String personInfo = reader.readLine();
        System.out.println(personInfo);

        Person personalInfo = peopleMap.get(personInfo);
        System.out.println(personalInfo);
    }
}
