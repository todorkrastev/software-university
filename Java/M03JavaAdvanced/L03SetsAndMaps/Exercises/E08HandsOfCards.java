package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class E08HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Set<String>> map = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = reader.readLine())) {
            String name = input.trim().split(": ")[0];
            String[] cardsArray = input.trim().split(": ")[1].trim().split(", ");
            Set<String> cards = new HashSet<>(Arrays.asList(cardsArray));

            if (!map.containsKey(name)) {
                map.put(name, cards);
            } else {
                Set<String> currCards = map.get(name);
                currCards.addAll(cards);
                map.put(name, currCards);
            }
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            int points = calculatePoints(entry.getValue());
            System.out.printf("%s: %d%n", entry.getKey(), points);
        }
    }

    private static int calculatePoints(Set<String> cards) {
        Map<String, Integer> powers = getLettersPower();
        int sum = 0;

        for (String card : cards) {
            String firstSymbol = card.substring(0, card.length() - 1);
            String secondSymbol = card.substring(card.length() - 1);

            sum += powers.get(firstSymbol) * powers.get(secondSymbol);
        }
        return sum;
    }

    private static Map<String, Integer> getLettersPower() {
        Map<String, Integer> powers = new HashMap<>();
        powers.put("1", 1);
        powers.put("2", 2);
        powers.put("3", 3);
        powers.put("4", 4);
        powers.put("5", 5);
        powers.put("6", 6);
        powers.put("7", 7);
        powers.put("8", 8);
        powers.put("9", 9);
        powers.put("10", 10);
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);
        powers.put("C", 1);
        powers.put("D", 2);
        powers.put("H", 3);
        powers.put("S", 4);

        return powers;
    }
}
