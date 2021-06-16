package bg.softuni.java_advanced.exam_preparation_22_February_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<Integer> firstLootBoxQueue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLootBoxStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondLootBoxStack::push);

        //stack -> LIFO
//stack.push -> add element
//stack.pop -> remove element
//stack.peek -> getting topmost element

        //queue -> FIFO
//queue.offer -> add element -> returns false if queue is full
//queue.poll -> remove element -> returns null if queue is empty
//queue.peek -> check first element

        int claimedItemsCounter = 0;
        while (!firstLootBoxQueue.isEmpty() && !secondLootBoxStack.isEmpty()) {
            int firstItem = firstLootBoxQueue.peek();
            int lastItem = secondLootBoxStack.pop();
            int sum = firstItem + lastItem;

            if (sum % 2 == 0) {
                claimedItemsCounter += sum;
                firstLootBoxQueue.poll();
            } else {
                firstLootBoxQueue.offer(lastItem);
            }
        }
        if (firstLootBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (100 <= claimedItemsCounter) {
            System.out.printf("Your loot was epic! Value: %d%n", claimedItemsCounter);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", claimedItemsCounter);
        }
    }
}
