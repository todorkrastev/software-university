package bg.softuni.java_advanced.functional_programming.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class E02SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String input = reader.readLine();

        Function<String, IntStream> getIntStream = str -> Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt);

        Function<String, Long> getCount = str -> getIntStream.apply(str).count();

        Function<String, Integer> getSum = str -> getIntStream.apply(str).sum();

        System.out.println("Count = " + getCount.apply(input));
        System.out.println("Sum = " + getSum.apply(input));
    }
}
