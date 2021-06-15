package bg.softuni.java_advanced.exam_preparation_19_August_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P02_FlowerWreathsSecondOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split(", ")).mapToInt(Integer::parseInt).forEach(lilies::push);
        ArrayDeque<Integer> roses = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int leftFlowers = 0;
        int countWreaths = 0;

        while (lilies.peek() != null && roses.peek() != null) {

            int sum = lilies.pop() + roses.poll();

            while (15 < sum) {
                sum -= 2;
            }
            if (sum == 15) {
                countWreaths++;
            } else {
                leftFlowers += sum;
            }
        }
        countWreaths += leftFlowers / 15;

        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        } else {
            int diff = 5 - countWreaths;
            System.out.printf("You didn't make it, you need %d wreaths more!", diff);
        }
    }
}
