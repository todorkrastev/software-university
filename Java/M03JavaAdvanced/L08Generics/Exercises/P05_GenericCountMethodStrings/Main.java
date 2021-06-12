package bg.softuni.java_advanced.generics.exercises.P05_GenericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfLines = Integer.parseInt(reader.readLine());

        Box<String> stringBox = new Box<>();

        for (int i = 0; i < numOfLines; i++) {
            String input = reader.readLine();

            stringBox.add(input);
        }

        String strToCompare = reader.readLine();

        long counterStrings = stringBox.countGreaterThan(strToCompare);

        System.out.println(counterStrings);
    }
}
