package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;

public class E03MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfCommands = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numOfCommands; i++) {
            int[] commandParts = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int command = commandParts[0];

            switch (command) {
                case 1:
                    int element = commandParts[1];
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(maximumElement(stack));
                    break;
                default:
                    break;
            }
        }

    }

    private static int maximumElement(ArrayDeque<Integer> stack) {
        int maxElement = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            if (maxElement < integer) {
                maxElement = integer;
            }
        }
        return maxElement;
    }
}