package bg.softuni.java_advanced.basic_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class P04_SetCover {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] universe = Arrays.stream(reader.readLine().substring(10).split(", ")).mapToInt(Integer::parseInt).toArray();
        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();

        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }
        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder output = new StringBuilder();
        output.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            output.append("{ ");
            output.append(Arrays.toString(set).replaceAll("[\\[\\]]", ""));
            output.append(" }").append(System.lineSeparator());
        }
        System.out.println(output);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {

        List<int[]> selectedSet = new ArrayList<>();
        Set<Integer> universeSet = Arrays.stream(universe).boxed().collect(Collectors.toCollection(HashSet::new));

        while (!universeSet.isEmpty() && !sets.isEmpty()) {
            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);
            for (int[] set : sets) {
                int count = 0;
                for (int element : set) {
                    if (universeSet.contains(element)) {
                        count++;
                    }
                }
                if (notChosenCount < count) {
                    notChosenCount = count;
                    chosenSet = set;
                }
            }
            selectedSet.add(chosenSet);
            Arrays.stream(chosenSet).forEach(universeSet::remove);
        }
        return selectedSet;
    }
}
