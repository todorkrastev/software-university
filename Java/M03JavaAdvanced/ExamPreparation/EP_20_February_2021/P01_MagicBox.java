package bg.softuni.java_advanced.exam_preparation_20_February_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_MagicBox {

    private static ArrayDeque<Integer> firstMagicBoxQueue;
    private static ArrayDeque<Integer> secondMagicBoxStack;
    private static int sum = 0;
    private static int claimedItemsCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        // queue
        firstMagicBoxQueue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        // stack
        secondMagicBoxStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondMagicBoxStack::push);

        while (!firstMagicBoxQueue.isEmpty() && !secondMagicBoxStack.isEmpty()) {
            int firstBoxElement = firstMagicBoxQueue.peek();
            int secondBoxElement = secondMagicBoxStack.peek();
            sum = firstBoxElement + secondBoxElement;

            if (isEven()) {
                countClaimedItems();
                removeElements();
            } else {
                removeAndAdd();
            }
        }
        if (firstMagicBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondMagicBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (90 <= claimedItemsCounter) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", claimedItemsCounter);
        } else {
            System.out.printf("Poor prey... Value: %d%n", claimedItemsCounter);
        }
    }

    private static void removeAndAdd() {
        firstMagicBoxQueue.offer(secondMagicBoxStack.pop());
    }

    private static void countClaimedItems() {
        claimedItemsCounter += sum;
    }

    private static void removeElements() {
        firstMagicBoxQueue.poll();
        secondMagicBoxStack.pop();

    }

    private static boolean isEven() {
        return sum % 2 == 0;
    }
}
