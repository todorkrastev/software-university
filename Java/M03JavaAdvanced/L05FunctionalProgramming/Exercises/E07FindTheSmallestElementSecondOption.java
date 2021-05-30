package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class E07FindTheSmallestElementSecondOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Integer> numbers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> findIndexOfSmallestNum = list -> System.out.println(list.lastIndexOf(Collections.min(list)));

        findIndexOfSmallestNum.accept(numbers);
    }
}
