package bg.softuni.java_advanced.iterators_and_comparators.exercises.P03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Stack myStack = new Stack();
        Arrays.stream(reader.readLine().trim().replaceAll("Push\\s+", "").trim().split(", "))
                .mapToInt(Integer::parseInt).forEach(myStack::push);
        String command;
        while (!"END".equals(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            if (input[0].equals("Pop")) {
                try {
                    myStack.pop();
                } catch (IllegalStateException ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (input[0].equals("Push")) {
                myStack.push(Integer.parseInt(input[1].trim()));
            }
        }
        IntStream.range(0, 2).forEach(i -> {
            for (Integer integer : myStack) {
                System.out.println(integer);
            }
        });
    }
}