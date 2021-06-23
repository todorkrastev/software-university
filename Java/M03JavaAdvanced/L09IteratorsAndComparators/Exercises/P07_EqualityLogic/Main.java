package bg.softuni.java_advanced.iterators_and_comparators.exercises.P07_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Set<Person> first = new TreeSet<>(new ComparatorByHashCode());
        Set<Person> second = new HashSet<>();
        int n = Integer.parseInt(reader.readLine());
        IntStream.range(0, n).mapToObj(input -> {
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
            first.add(person);
            second.add(person);
        });
        System.out.printf("%d%n%d", first.size(), second.size());
    }
}
