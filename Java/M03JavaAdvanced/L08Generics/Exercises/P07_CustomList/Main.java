package bg.softuni.java_advanced.generics.exercises.P07_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Box<String> stringBox = new Box<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String command = tokens[0];

            String element;
            int index;
            switch (command) {
                case "Add":
                    element = tokens[1];

                    stringBox.add(element);
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);

                    stringBox.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];

                    System.out.println(stringBox.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    stringBox.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = tokens[1];

                    long counter = stringBox.countGreaterThan(element);

                    System.out.println(counter);
                    break;
                case "Max":
                    System.out.println(stringBox.getMax());

                    break;
                case "Min":
                    System.out.println(stringBox.getMin());

                    break;
                case "Print":
                    System.out.println(stringBox);
                    break;
                default:
                    break;
            }
        }
    }
}
