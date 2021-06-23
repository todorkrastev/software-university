package bg.softuni.java_advanced.iterators_and_comparators.exercises.P05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Person> personInfo = new ArrayList<>();
        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String town = data[2];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, town, age);
            personInfo.add(person);
        }

        int n = Integer.parseInt(reader.readLine());
        Person findPerson = personInfo.get(n - 1);
        long equals = personInfo.stream().filter(e -> findPerson.compareTo(e) == 0).count();

        if (equals == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equals, personInfo.size() - equals, personInfo.size());
        }
    }
}
