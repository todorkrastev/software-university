package bg.softuni.java_advanced.preparation_exam_28_June_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P01_Bombs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<Integer> effects = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split(", ")).mapToInt(Integer::parseInt).forEach(casings::push);

        Map<String, Integer> bombsMap = new TreeMap<>();
        bombsMap.put("Cherry Bombs", 0);
        bombsMap.put("Datura Bombs", 0);
        bombsMap.put("Smoke Decoy Bombs", 0);

        while (!effects.isEmpty() && !casings.isEmpty()) {
            if (hasAllBombs(bombsMap)) {
                break;
            }

            int currEffects = effects.peek();
            int currCasings = casings.pop();

            int sum = currEffects + currCasings;

            if (sum == 40) {
                removeElements(effects);
                bombsMap.put("Datura Bombs", bombsMap.get("Datura Bombs") + 1);
            } else if (sum == 60) {
                removeElements(effects);
                bombsMap.put("Cherry Bombs", bombsMap.get("Cherry Bombs") + 1);
            } else if (sum == 120) {
                removeElements(effects);
                bombsMap.put("Smoke Decoy Bombs", bombsMap.get("Smoke Decoy Bombs") + 1);
            } else {
                casings.push(currCasings - 5);
            }
        }

        if (hasAllBombs(bombsMap)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        String effectsOutput = "Bomb Effects: "
                + (effects.isEmpty() ? "empty" :
                effects.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")));

        System.out.println(effectsOutput);

        String casingsOutput = "Bomb Casings: "
                + (casings.isEmpty() ? "empty" :
                casings.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")));

        System.out.println(casingsOutput);

        bombsMap
                .forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }

    private static boolean hasAllBombs(Map<String, Integer> bombsMap) {
        return bombsMap.get("Cherry Bombs") >= 3 && bombsMap.get("Datura Bombs") >= 3 && bombsMap.get("Smoke Decoy Bombs") >= 3;
    }

    private static void removeElements(ArrayDeque<Integer> effects) {
        effects.poll();
    }
}
