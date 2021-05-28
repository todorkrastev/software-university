package bg.softuni.java_advanced.functional_programming.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class E02KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] names = reader.readLine().trim().split("\\s+");
        Consumer<String[]> print = strArr -> {
            for (int i = 0; i < strArr.length; i++) {
                System.out.println("Sir " + names[i]);
            }
        };
        print.accept(names);
    }
}
