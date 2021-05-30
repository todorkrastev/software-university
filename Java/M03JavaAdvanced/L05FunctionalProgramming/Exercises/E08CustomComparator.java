package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class E08CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Integer> numbers = readList(reader);

        Comparator<Integer> getSortedEvenAndOddNum = getIntegerComparator();

        Consumer<Integer> printer = getPrinter();

        numbers
                .stream()
                .sorted(getSortedEvenAndOddNum)
                .forEach(printer);
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Consumer<Integer> getPrinter() {
        return number -> System.out.print(number + " ");
    }

    private static Comparator<Integer> getIntegerComparator() {
        return ((o1, o2) -> {
            if (o1 % 2 == 0 && o2 % 2 == 0) {
                return o1.compareTo(o2);
            } else if (o1 % 2 == 0 && o2 % 2 != 0) {
                return -1;
            } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                return 1;
            }
            return o1.compareTo(o2);
        });
    }
}
