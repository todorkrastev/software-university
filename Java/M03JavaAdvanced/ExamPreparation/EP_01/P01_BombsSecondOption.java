package bg.softuni.java_advanced.preparation_exam_28_June_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class P01_BombsSecondOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        ArrayDeque<Integer> effects = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(reader.readLine().trim().split(", ")).mapToInt(Integer::parseInt).forEach(casings::push);

        int countDaturaBomb = 0;
        int countCherryBomb = 0;
        int countSmokeBomb = 0;

        while (!effects.isEmpty() && !casings.isEmpty() && (countCherryBomb < 3 || countSmokeBomb < 3 || countDaturaBomb < 3)) {
            int currEffects = effects.poll();
            int currCasings = casings.pop();
            int sum = currEffects + currCasings;

            if (sum == 40) {
                countDaturaBomb++;
            } else if (sum == 60) {
                countCherryBomb++;
            } else if (sum == 120) {
                countSmokeBomb++;
            } else {
                casings.push(currCasings - 5);
                effects.offerFirst(currEffects);
            }
        }

        if (countCherryBomb >= 3 && countSmokeBomb >= 3 && countDaturaBomb >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n", String.join(", ", effects.toString().replaceAll("[\\[\\]]", "")));
        }

        if (casings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n", String.join(", ", casings.toString().replaceAll("[\\[\\]]", "")));
        }

        System.out.printf("Cherry Bombs: %d%nDatura Bombs: %d%nSmoke Decoy Bombs: %d%n", countCherryBomb, countDaturaBomb, countSmokeBomb);
    }
}
