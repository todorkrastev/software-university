package bg.softuni.java_oop.working_with_abstraction.exercises.P06_GreedyTimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        long capacity = Long.parseLong(reader.readLine());
        String[] input = reader.readLine().trim().split("\\s+");
        Bag bag = new Bag(capacity);

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i].trim();
            long quantity = Long.parseLong(input[i + 1].trim());
            if (item.length() == 3) {
                bag.addCash(item, quantity);
            } else if (item.toLowerCase().endsWith("gem")) {
                bag.addGem(item, quantity);
            } else if (item.equalsIgnoreCase("gold")) {
                bag.addGold(quantity);
            }
        }
        System.out.println(bag.ordered());
    }
}
