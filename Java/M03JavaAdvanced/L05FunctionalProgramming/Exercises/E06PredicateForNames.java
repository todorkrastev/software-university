package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class E06PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int nameMaxLen = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().trim().split("\\s+");

        Predicate<String> isNameInRange = name -> name.length() <= nameMaxLen;
        Consumer<String> printer = System.out::println;

        Arrays.stream(names).filter(isNameInRange).forEach(printer);
    }
}
