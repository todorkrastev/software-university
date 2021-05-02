package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;

public class E04BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        // N -> the number of elements to enqueue
        // S -> the number of elements to dequeue
        // X -> an element that I should check whether is presented in the queue

        int[] integers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = integers[0];
        int S = integers[1];
        int X = integers[2];

        int[] numbers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < S; i++) {
            if (!queue.isEmpty()) {
                queue.poll();
            }
        }

        if (queue.contains(X)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(smallestElement(queue));
        }
    }

    private static int smallestElement(ArrayDeque<Integer> queue) {
        int smallestEl = Integer.MAX_VALUE;

        for (Integer integer : queue) {
            if (integer < smallestEl) {
                smallestEl = integer;
            }
        }
        return smallestEl;
    }
}