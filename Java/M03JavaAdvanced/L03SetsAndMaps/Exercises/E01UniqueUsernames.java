package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E01UniqueUsernames {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Set<String> userList = IntStream
                .range(0, num)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        userList
                .forEach(System.out::println);
    }
}
