package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class E03WarNumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Set<Integer> firstDeck = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;

        while (round-- != 0 && (!firstDeck.isEmpty() && !secondDeck.isEmpty())) {
            int firstPlayer = firstDeck.iterator().next();
            int secondPlayer = secondDeck.iterator().next();

            firstDeck.remove(firstPlayer);
            secondDeck.remove(secondPlayer);

            if (firstPlayer > secondPlayer) {
                firstDeck.add(firstPlayer);
                firstDeck.add(secondPlayer);
            } else if (secondPlayer > firstPlayer) {
                secondDeck.add(firstPlayer);
                secondDeck.add(secondPlayer);
            }
        }
        if (firstDeck.size() == secondDeck.size()) {
            System.out.println("Draw!");
        } else if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
