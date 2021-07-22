package bg.softuni.java_oop.exception_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class P02_EnterNumbers {

    public static boolean proceed = true;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String message = "Enter valid Integers in range 1 < start < end < 100";
        System.out.println(message);

        while (proceed) {
            try {
                int start = Integer.parseInt(reader.readLine());
                int end = Integer.parseInt(reader.readLine());
                printNumbers(start, end);
            } catch (NumberFormatException exception) {
                System.out.println(message);
            }
        }
    }

    public static void printNumbers(int start, int end) {
        if (!(start < end) || !(start > 1) || !(end < 100)) {
            throw new NumberFormatException();
        }
        IntStream.rangeClosed(start, end).forEach(System.out::println);
        proceed = false;
    }
}
