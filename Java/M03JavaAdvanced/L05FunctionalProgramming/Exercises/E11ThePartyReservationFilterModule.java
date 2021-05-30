package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<String> guestList = Arrays
                .stream(reader.readLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> predicates = new HashSet<>();

        String input;

        while (!"Print".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split(";");
            String command = tokens[0];

            if (command.contains("Add")) {
                predicates.add(tokens[1] + "," + tokens[2]);
            } else {
                predicates.remove(tokens[1] + "," + tokens[2]);
            }
        }
        predicates
                .forEach(predicate -> guestList.removeIf(getPredicate(predicate)));

        System.out.println(String.join(" ", guestList));
    }

    private static Predicate<String> getPredicate(String commands) {
        Predicate<String> predicate;

        String[] tokens = commands.trim().split(",");
        String command = tokens[0];

        switch (command) {
            case "StartsWith":
                predicate = name -> name.startsWith(tokens[1]);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(tokens[1]);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(tokens[1]);
                break;
            default:
                predicate = names -> names.contains(tokens[1]);
                break;
        }
        return predicate;
    }
}