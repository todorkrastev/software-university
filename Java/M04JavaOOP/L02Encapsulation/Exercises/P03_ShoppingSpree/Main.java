package bg.softuni.java_oop.encapsulation.exercises.P03_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final Map<String, Person> people = new LinkedHashMap<>();
    private static final Map<String, Product> products = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        try {
            setObject(reader, "Person");
            setObject(reader, "Product");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        String command;
        while (!"END".equals(command = reader.readLine())) {
            try {
                String[] tokens = command.split("\\s+");
                people.get(tokens[0]).buyProduct(products.get(tokens[1]));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        people
                .values()
                .forEach(person -> System.out.println(person.toString()));
    }

    private static void setObject(BufferedReader reader, String clazz) throws IOException {
        String[] inputData = reader.readLine().trim().split(";");
        Arrays.stream(inputData).map(s -> s.split("=")).forEach(data -> {
            var object = clazz.equals("Person")
                    ? people.put(data[0].trim(), new Person(data[0].trim(), Double.parseDouble(data[1].trim())))
                    : products.put(data[0].trim(), new Product(data[0].trim(), Double.parseDouble(data[1].trim())));
        });
    }
}
