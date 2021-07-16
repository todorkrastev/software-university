package bg.softuni.java_oop.polymorphism.exercises.P04_Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        StringBuilder text = new StringBuilder(reader.readLine());

        CommandInterface commandInterface = Initialization.buildCommandInterface(text);

        String inputLine = reader.readLine();

        while (!inputLine.equals("exit")) {
            commandInterface.handleInput(inputLine);
            inputLine = reader.readLine();
        }

        System.out.println(text);
    }
}
