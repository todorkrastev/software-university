package bg.softuni.java_advanced.iterators_and_comparators.exercises.P06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Set<Person> personByName = new TreeSet<>(new ComparatorByName());
        Set<Person> personByAge = new TreeSet<>(new ComparatorByAge());
        int n = Integer.parseInt(reader.readLine());
        IntStream.range(0, n).mapToObj(i -> {
            try {
                return reader.readLine().trim().split("\\s+");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return new String[0];
        }).forEach(input -> {
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            personByName.add(person);
            personByAge.add(person);
        });
        personByName.forEach(System.out::println);
        personByAge.forEach(System.out::println);
    }
}
