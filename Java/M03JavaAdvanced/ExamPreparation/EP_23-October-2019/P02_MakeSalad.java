package bg.softuni.java_advanced.exam_preparation_23_October_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P02_MakeSalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<String> vegetablesQueue = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> caloriesStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(caloriesStack::push);

        List<Integer> readySalad = new ArrayList<>();

        while (!vegetablesQueue.isEmpty() && !caloriesStack.isEmpty()) {
            int valueOfSalad = caloriesStack.pop();
            readySalad.add(valueOfSalad);
            while (!vegetablesQueue.isEmpty() && valueOfSalad > 0) {
                switch (vegetablesQueue.poll()) {
                    case "tomato":
                        valueOfSalad -= 80;
                        break;
                    case "carrot":
                        valueOfSalad -= 136;
                        break;
                    case "lettuce":
                        valueOfSalad -= 109;
                        break;
                    case "potato":
                        valueOfSalad -= 215;
                        break;
                }
            }
        }
        System.out.println(readySalad.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        if (!vegetablesQueue.isEmpty()) {
            System.out.println(vegetablesQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        if (!caloriesStack.isEmpty()) {
            System.out.println(caloriesStack.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}