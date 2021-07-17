package bg.softuni.java_oop.polymorphism.exercises.P05_Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        String[] tokens = reader.readLine().trim().split("\\s+");

        Arrays
                .stream(tokens)
                .takeWhile(token -> !token.equals("end"))
                .forEach(interpreter::interpret);

        System.out.println(engine.getCurrentResult());
    }
}
