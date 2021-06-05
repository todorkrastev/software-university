package bg.softuni.java_advanced.defining_classes.exercises.P01_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int num = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] input = reader.readLine().trim().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            people.add(person);
        }
        Predicate<Person> getFilterAge = person -> person.getAge() > 30;
        Comparator<Person> getNaturalOrder = ((p1, p2) -> p1.getName().compareTo(p2.getName()));
        Consumer<Person> printer = person -> System.out.println(person);

        people
                .stream()
                .filter(getFilterAge)
                .sorted(getNaturalOrder)
                .forEach(printer);
    }
}
