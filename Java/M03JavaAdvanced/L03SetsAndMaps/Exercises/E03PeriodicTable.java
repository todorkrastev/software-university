package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfChemCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> chemCompounds = IntStream
                .range(0, numOfChemCompounds)
                .mapToObj(i -> scanner.nextLine().split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toCollection(TreeSet::new));

        chemCompounds
                .stream()
                .map(equals -> equals + " ")
                .forEach(System.out::print);
    }
}
