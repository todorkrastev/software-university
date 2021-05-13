package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lenFirstSet = numbers[0];
        int lenSecondSet = numbers[1];

        Set<Integer> firstSet = IntStream
                .range(0, lenFirstSet)
                .mapToObj(i -> Integer.parseInt(scanner.nextLine()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondSet = IntStream
                .range(0, lenSecondSet)
                .mapToObj(i -> Integer.parseInt(scanner.nextLine()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        firstSet
                .stream()
                .filter(secondSet::contains)
                .map(equals -> equals + " ")
                .forEach(System.out::print);
    }
}
