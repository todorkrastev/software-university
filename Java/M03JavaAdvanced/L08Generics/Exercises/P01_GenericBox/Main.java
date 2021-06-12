package bg.softuni.java_advanced.generics.exercises.P01_GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfStrLines = Integer.parseInt(reader.readLine());

        Box<String> box = new Box();

        for (int i = 0; i < numOfStrLines; i++) {
            String input = reader.readLine();

            box.add(input);
        }
        System.out.println(box);
    }
}
