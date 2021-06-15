package bg.softuni.java_advanced.exam_preparation_19_August_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P01_FlowerWreaths {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //stack -> LIFO
//stack.push -> add element
//stack.pop -> remove element
//stack.peek -> getting topmost element

        //queue -> FIFO
//queue.offer -> add element -> returns false if queue is full
//queue.poll -> remove element -> returns null if queue is empty
//queue.peek -> check first element

        int leftover = 0;

        int flowerWreathsCounter = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int flowerLilies = liliesStack.peek();
            int flowerRoses = rosesQueue.peek();
            int sum = flowerLilies + flowerRoses;

            if (sum == 15) {
                flowerWreathsCounter++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (15 < sum) {
                liliesStack.push(liliesStack.pop() - 2);
            } else {
                leftover += liliesStack.pop() + rosesQueue.poll();
            }
        }
        while (15 <= leftover) {
            leftover -= 15;
            flowerWreathsCounter++;
        }

        if (flowerWreathsCounter < 5) {
            int diff = 5 - flowerWreathsCounter;
            System.out.printf("You didn't make it, you need %d wreaths more!%n", diff);
        } else {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", flowerWreathsCounter);
        }
    }
}
