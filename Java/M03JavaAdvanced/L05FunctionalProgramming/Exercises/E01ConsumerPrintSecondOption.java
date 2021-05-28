package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Consumer;

public class E01ConsumerPrintSecondOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] names = reader.readLine().trim().split("\\+");
        Consumer<String> print = System.out::println;

        Arrays.stream(names).forEach(print);
    }
}
