package bg.softuni.java_advanced.generics.exercises.P06_GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfLines = Integer.parseInt(reader.readLine());

        Box<Double> stringBox = new Box<>();

        for (int i = 0; i < numOfLines; i++) {
            double input = Double.parseDouble(reader.readLine());

            stringBox.add(input);
        }

        double strToCompare = Double.parseDouble(reader.readLine());

        long counterStrings = stringBox.countGreaterThan(strToCompare);

        System.out.println(counterStrings);
    }
}
