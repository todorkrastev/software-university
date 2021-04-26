package bg.softuni.java_advanced.stacks_and_queues.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;

public class E10PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfPlants = Integer.parseInt(reader.readLine());

        int[] plants = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);
        int[] days = new int[numOfPlants];

        for (int i = 1; i < numOfPlants; i++) {
            int lastDay = 0;
            while (!indexes.isEmpty() && plants[indexes.peek()] >= plants[i]) {
                lastDay = Math.max(lastDay, days[indexes.pop()]);
            }
            if (!indexes.isEmpty()) {
                days[i] = lastDay + 1;
            }
            indexes.push(i);
        }
        System.out.println(getLastDay(days));
    }

    private static int getLastDay(int[] days) {
        return Arrays.stream(days).filter(day -> day >= 0).max().orElse(0);
    }
}