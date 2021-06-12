package bg.softuni.java_advanced.generics.exercises.P02_GenericBoxOfInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfLines = Integer.parseInt(reader.readLine());

        Box<Integer> integerBox = new Box<>();

        for (int i = 0; i < numOfLines; i++) {
            int num = Integer.parseInt(reader.readLine());

            integerBox.add(num);
        }
        System.out.println(integerBox);
    }
}
