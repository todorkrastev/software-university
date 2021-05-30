package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class E09ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int rangeNum = Integer.parseInt(reader.readLine());

        List<Integer> numbers = readList(reader);

        BiFunction<List<Integer>, Integer, Boolean> predicate = getPredicate();

        printResult(rangeNum, numbers, predicate);
    }

    private static void printResult(int rangeNum, List<Integer> numbers, BiFunction<List<Integer>, Integer, Boolean> predicate) {
        for (int number = 1; number <= rangeNum; number++) {
            if (predicate.apply(numbers, number)) {
                System.out.print(number + " ");
            }
        }
    }

    private static BiFunction<List<Integer>, Integer, Boolean> getPredicate() {
        return ((list, number) -> {
            for (Integer numInList : list) {
                if (number % numInList != 0) {
                    return false;
                }
            }
            return true;
        });
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
