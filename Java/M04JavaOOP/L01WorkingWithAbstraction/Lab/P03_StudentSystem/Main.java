package bg.softuni.java_oop.working_with_abstraction.lab.P03_StudentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        StudentSystem studentSystem = new StudentSystem();

        String input;
        while (!"Exit".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String output = studentSystem.parseCommand(tokens);
            if (output != null) {
                System.out.println(output);
            }
        }
    }
}
