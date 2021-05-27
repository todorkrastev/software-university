package bg.softuni.java_advanced.functional_programming.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class E06FindEverOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] lowerAndUpperBound = reader.readLine().trim().split("\\s+");
        int lowerBound = Integer.parseInt(lowerAndUpperBound[0]);
        int upperBound = Integer.parseInt(lowerAndUpperBound[1]);

        String command = reader.readLine();

        Predicate<Integer> isEven = n -> n % 2 == 0;

        IntStream.range(lowerBound, upperBound + 1)
                .filter(n -> "even".equals(command) == isEven.test(n))
                .forEach(e -> System.out.printf("%d ", e));
    }
}
