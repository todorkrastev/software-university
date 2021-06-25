package bg.softuni.java_advanced.exam_preparation_14_April_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_Bouquets {

    private static ArrayDeque<Integer> tulipsStack;
    private static ArrayDeque<Integer> daffodilsQueue;
    private static int bouquetsCounter = 0;
    private static int leftovers = 0;
    private static int sum = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        tulipsStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(tulipsStack::push);
        daffodilsQueue = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {
            int currDaffodil = daffodilsQueue.peek();
            int currTulip = tulipsStack.peek();
            sum = currDaffodil + currTulip;
            if (isEqualTo15()) {
                removeBothElements();
            } else if (isMoreThan15()) {
                whileMoreThan15(currDaffodil);
            } else if (isLessThan15()) {
                keepLeftovers();
            }
        }
        if (0 < leftovers) {
            bouquetsCounter += leftovers / 15;
        }
        if (5 <= bouquetsCounter) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquetsCounter);
        } else {
            int diff = 5 - bouquetsCounter;
            System.out.printf("You failed... You need more %d bouquets.", diff);
        }
    }

    private static void keepLeftovers() {
        leftovers += daffodilsQueue.peek() + tulipsStack.peek();
        removeBothElements();
    }

    private static boolean isLessThan15() {
        return sum < 15;
    }

    private static void removeBothElements() {
        daffodilsQueue.poll();
        tulipsStack.pop();
        if (isEqualTo15()) {
            bouquetsCounter++;

        }
    }

    private static void whileMoreThan15(int currDaffodil) {
        while (!tulipsStack.isEmpty() && 15 < sum) {
            tulipsStack.push(tulipsStack.pop() - 2);
            sum = currDaffodil + tulipsStack.peek();
        }

        if (isEqualTo15()) {
            removeBothElements();
        } else if (isLessThan15()) {
            keepLeftovers();
        }
    }

    private static boolean isMoreThan15() {
        return 15 < sum;
    }

    private static boolean isEqualTo15() {
        return sum == 15;
    }
}
