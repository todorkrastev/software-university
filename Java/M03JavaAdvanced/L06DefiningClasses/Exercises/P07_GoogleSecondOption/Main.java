package bg.softuni.java_advanced.defining_classes.exercises.P07_GoogleSecondOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        Map<String, Person> personInfo = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String nameOfPerson = tokens[0];
            String command = tokens[1];

            personInfo.putIfAbsent(nameOfPerson,
                    new Person(nameOfPerson, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

            switch (command) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company =
                            new Company(companyName, department, salary);

                    personInfo.get(nameOfPerson).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    personInfo.get(nameOfPerson).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parent parent = new Parent(parentName, parentBirthday);

                    personInfo.get(nameOfPerson).getParentList().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Children children = new Children(childName, childBirthday);

                    personInfo.get(nameOfPerson).getChildrenList().add(children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    personInfo.get(nameOfPerson).setCar(car);
                    break;
            }
        }
        personInfo.get(reader.readLine()).printFormat();
    }
}
