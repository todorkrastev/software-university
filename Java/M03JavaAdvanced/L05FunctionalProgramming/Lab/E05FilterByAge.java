package bg.softuni.java_advanced.functional_programming.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E05FilterByAge {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int number = Integer.parseInt(reader.readLine());

        Function<String, Person> parsePerson = s ->
                new Person(s.split(", ")[0], Integer.parseInt(s.split(", ")[1]));

        List<Person> people = new ArrayList<>();

        while (number-- > 0) {
            people.add(parsePerson.apply(reader.readLine()));
        }

        String condition = reader.readLine();
        int ageCondition = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        people = condition.equals("older")
                ? filterPeople(people, p -> p.age >= ageCondition)
                : filterPeople(people, p -> p.age <= ageCondition);

        System.out.println(formatPeople(people, getFormatFunction(format), System.lineSeparator()));

    }

    private static Function<Person, String> getFormatFunction(String formatType) {
        switch (formatType) {
            case "name":
                return p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
            case "name age":
                return p -> p.name + " - " + p.age;
            default:
                throw new IllegalStateException("Unknown format type" + formatType);
        }
    }

    public static String formatPeople(Collection<Person> people, Function<Person, String> formatter, String delimiter) {
        return people.stream().map(formatter).collect(Collectors.joining(delimiter));
    }

    public static List<Person> filterPeople(Collection<Person> people, Predicate<Person> predicate) {
        return people.stream().filter(predicate).collect(Collectors.toList());
    }
}