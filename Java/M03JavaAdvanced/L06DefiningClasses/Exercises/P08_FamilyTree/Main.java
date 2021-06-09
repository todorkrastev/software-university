package bg.softuni.java_advanced.defining_classes.exercises.P08_FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String personId = reader.readLine();

        List<Person> people = new ArrayList<>();

        Map<String, List<String>> parentAndChildren = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            if (input.contains(" - ")) {
                String[] data = input.split(" - ");
                String parentId = data[0];
                String childrenId = data[1];

                parentAndChildren.putIfAbsent(parentId, new ArrayList<>());

                parentAndChildren.get(parentId).add(childrenId);
            } else {
                String[] data = input.split("\\s+");
                String name = data[0] + " " + data[1];
                String birthDate = data[2];

                people.add(new Person(name, birthDate));
            }
        }
        parentAndChildren.forEach((parentId, children) -> {
            Person parent = Person.findPerson(people, parentId);
            children.stream().map(childId -> Person.findPerson(people, childId)).forEach(parent::addChild);
        });
        Person forPerson = Person.findPerson(people, personId);
        System.out.println(Person.getFamilyTreeFor(forPerson));
    }
}

