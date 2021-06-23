package bg.softuni.java_advanced.iterators_and_comparators.exercises.P04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Lake lake = new Lake(Arrays.stream(reader.readLine().trim().split(", ")).mapToInt(Integer::parseInt).toArray());
        Iterator<Integer> iterator = lake.iterator();
        while (iterator.hasNext()) {
            String current = iterator.next().toString();
            System.out.print(iterator.hasNext() ? String.format("%s, ", current) : current);
        }
    }
}
