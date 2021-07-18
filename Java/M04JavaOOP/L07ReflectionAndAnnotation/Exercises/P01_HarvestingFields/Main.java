package bg.softuni.java_oop.reflection_and_annotation.exercises.P01_HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String command;
        while (!"harvest".equalsIgnoreCase(command = reader.readLine())) {
            String modifier = command;

            Arrays.stream(RichSoilLand.class.getDeclaredFields())
                    .filter(field ->
                            Modifier.toString(field.getModifiers()).equals(modifier) || modifier.equals("all"))
                    .forEach(f -> System.out.printf("%s %s %s%n",
                            Modifier.toString(f.getModifiers()),
                            f.getType().getSimpleName(),
                            f.getName()));
        }
    }
}
