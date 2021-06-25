package bg.softuni.java_advanced.basic_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P01_RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] numbers = Arrays.stream(reader.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(numbers, 0));
    }

    private static int sum(int[] numbers, int index) {

        return index == numbers.length - 1 ? numbers[index] : numbers[index] + sum(numbers, index + 1);
    }
}
