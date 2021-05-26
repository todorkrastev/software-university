package bg.softuni.java_advanced.functional_programming.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class E01SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] numbers = Arrays.stream(reader.readLine().trim().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .toArray();

        System.out.println(formattingArray(numbers));

        Arrays.sort(numbers);

        System.out.println(formattingArray(numbers));
    }

    static String formattingArray(int[] array) {
        return Arrays
                .stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
