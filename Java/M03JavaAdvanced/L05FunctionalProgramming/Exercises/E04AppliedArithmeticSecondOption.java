package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E04AppliedArithmeticSecondOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Integer> numbers = getIntegers(reader);

        Function<List<Integer>, List<Integer>> add = getAdd();
        Function<List<Integer>, List<Integer>> multiply = getMultiply();
        Function<List<Integer>, List<Integer>> subtract = getSubtract();
        Consumer<List<Integer>> printer = getPrinter();

        String command;
        while (!"end".equals(command = reader.readLine())) {
            switch (command) {
                case "add":
                    add.apply(numbers);
                    break;
                case "multiply":
                    multiply.apply(numbers);
                    break;
                case "subtract":
                    subtract.apply(numbers);
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

    private static List<Integer> getIntegers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Consumer<List<Integer>> getPrinter() {
        return number -> {
            for (Integer integer : number) {
                System.out.print(integer + " ");
            }
        };
    }

    private static Function<List<Integer>, List<Integer>> getSubtract() {
        return list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) - 1);
            }
            return list;
        };
    }

    private static Function<List<Integer>, List<Integer>> getMultiply() {
        return list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 2);
            }
            return list;
        };
    }

    private static Function<List<Integer>, List<Integer>> getAdd() {
        return list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + 1);
            }
            return list;
        };
    }
}
