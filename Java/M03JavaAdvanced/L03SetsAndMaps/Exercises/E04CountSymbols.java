package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.util.*;
import java.util.stream.IntStream;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> map = new TreeMap<>();

        IntStream.range(0, input.length()).forEach(i -> map.put(input.charAt(i),
                !map.containsKey(input.charAt(i)) ? 1 : map.get(input.charAt(i)) + 1));
        map.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
