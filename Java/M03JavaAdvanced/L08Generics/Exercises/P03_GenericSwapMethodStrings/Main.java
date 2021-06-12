package bg.softuni.java_advanced.generics.exercises.P03_GenericSwapMethodStrings;

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
        String[] tokens = reader.readLine().trim().split("\\s+");
        int firstIndex = Integer.parseInt(tokens[0]);
        int secondIndex = Integer.parseInt(tokens[1]);

        stringBox.swap(firstIndex, secondIndex);

        System.out.println(stringBox);
    }
}
