package bg.softuni.java_advanced.exam_preparation_26_October_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_DatingApp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));


        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matchesCounter = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            //stack -> LIFO
//stack.push -> add element
//stack.pop -> remove element
//stack.peek -> getting topmost element

            //queue -> FIFO
//queue.offer -> add element -> returns false if queue is full
//queue.poll -> remove element -> returns null if queue is empty
//queue.peek -> check first element

            if (malesStack.peek() <= 0 || femalesQueue.peek() <= 0 || malesStack.peek() % 25 == 0 || femalesQueue.peek() % 25 == 0) {
                extracted(malesStack);
                extracted(femalesQueue);
            } else {
                if (malesStack.peek().equals(femalesQueue.peek())) {
                    matchesCounter++;
                    malesStack.pop();
                } else {
                    malesStack.push(malesStack.pop() - 2);
                }
                femalesQueue.poll();
            }
        }
        System.out.println("Matches: " + matchesCounter);

        System.out.println(malesStack.isEmpty() ? "Males left: none"
                : String.format("Males left: %s",
                malesStack
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))));

        System.out.println(femalesQueue.isEmpty() ? "Females left: none"
                : String.format("Females left: %s",
                femalesQueue
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))));

    }

    private static void extracted(ArrayDeque<Integer> collection) {
        if (!collection.isEmpty()) {
            if (collection.peek() <= 0) {
                collection.pop();
            } else if (collection.peek() % 25 == 0) {
                collection.pop();
                collection.pop();
            }
        }
    }
}
