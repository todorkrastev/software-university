package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;

public class E02BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        // N -> number of elements to push onto the stack
        // S -> number of elements to pop from the stack
        // X -> element that I should check whether is present in the stack.
        // if the stack is empty, print 0

        int[] nsx = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = nsx[0];
        int S = nsx[1];
        int X = nsx[2];

        int[] numbers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int number : numbers) {
            stack.push(number);
        }

        boolean isTrue = true;

        if (N != numbers.length) {
            isTrue = false;
        }

        int count = S;
        while (0 < count) {
            stack.pop();
            count--;
        }

        if (!stack.contains(X)) {
            isTrue = false;
        }

        if (isTrue) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(smallestNumber(stack));
        }
    }

    private static int smallestNumber(ArrayDeque<Integer> stack) {
        int smallestNum = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if (integer < smallestNum) {
                smallestNum = integer;
            }
        }
        return smallestNum;
    }
}