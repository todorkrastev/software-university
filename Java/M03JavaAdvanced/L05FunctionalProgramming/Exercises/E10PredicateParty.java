package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty {

    static List<String> guestList = null;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        guestList = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"Party!".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String command = tokens[0];
            String firstCriteria = tokens[1];
            String secondCriteria = tokens[2];

            switch (command) {
                case "Double":
                    addOneMore(getPredicate(firstCriteria, secondCriteria));
                    break;
                case "Remove":
                    removeName(getPredicate(firstCriteria, secondCriteria));
                    break;
                default:
                    break;
            }
        }
        Collections.sort(guestList);

        Consumer<List<String>> printer = (list -> {
            if (list.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                System.out.println(String.join(", ", list) + " are going to the party!");
            }
        });

        printer.accept(guestList);
    }

    private static void removeName(Predicate<String> predicate) {
        guestList.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        guestList.stream().filter(predicate).forEach(namesToAdd::add);
        guestList.addAll(namesToAdd);
    }

    private static Predicate<String> getPredicate(String firstCriteria, String secondCriteria) {
        Predicate<String> predicate;

        if ("StartsWith".equals(firstCriteria)) {
            predicate = name -> name.startsWith(secondCriteria);
        } else if ("EndsWith".equals(firstCriteria)) {
            predicate = name -> name.endsWith(secondCriteria);
        } else {
            predicate = name -> name.length() == Integer.parseInt(secondCriteria);
        }
        return predicate;
    }
}
