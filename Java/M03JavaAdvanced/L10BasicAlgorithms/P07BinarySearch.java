package bg.softuni.java_advanced.basic_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P07BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] numbers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(reader.readLine());

        System.out.println(binarySearch(numbers, target));
    }

    private static int binarySearch(int[] numbers, int target) {

        int start = 0, end = numbers.length - 1;

        while (end >= start) {
            int half = (start + end) / 2;
            if (numbers[half] < target) {
                start = half + 1;
            } else if (numbers[half] > target) {
                end = half - 1;
            } else {
                return half;
            }
        }
        return -1;
    }
}
