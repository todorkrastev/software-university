package E05ProgrammingFundamentalsFinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class E03Pirates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, int[]> map = new TreeMap<>();

        String input;

        while (!"Sail".equals(input = reader.readLine())) {
            String[] split = input.trim().split("\\|\\|");
            String city = split[0];
            int population = Integer.parseInt(split[1]);
            int gold = Integer.parseInt(split[2]);

            map.putIfAbsent(city, new int[2]);
            map.get(city)[0] += population;
            map.get(city)[1] += gold;
        }

        String secondInput;
        while (!"End".equals(secondInput = reader.readLine())) {
            String[] commandParts = secondInput.trim().split("=>");
            String command = commandParts[0];
            String town = commandParts[1];

            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(commandParts[2]);
                    int gold = Integer.parseInt(commandParts[3]);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                    if (map.containsKey(town)) {
                        map.get(town)[0] -= people;
                        map.get(town)[1] -= gold;

                        if (map.get(town)[0] <= 0 || map.get(town)[1] <= 0) {
                            map.remove(town);
                            System.out.printf("%s has been wiped off the map!%n", town);
                        }
                    }
                    break;
                case "Prosper":
                    int goldProsper = Integer.parseInt(commandParts[2]);

                    if (goldProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        if (map.containsKey(town)) {
                            map.get(town)[1] += goldProsper;
                            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, town, map.get(town)[1]);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (map.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", map.size());
            map
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue()[1], a.getValue()[1]))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
        }
    }
}
