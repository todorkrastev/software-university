package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class E04AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] numbers = getNumbers(reader);
        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(n -> n += 1).toArray();
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr).map(n -> n *= 2).toArray();
        Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(n -> n -= 1).toArray();
        Consumer<int[]> printer = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String command;
        while (!"end".equals(command = reader.readLine())) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
    }

    private static int[] getNumbers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
