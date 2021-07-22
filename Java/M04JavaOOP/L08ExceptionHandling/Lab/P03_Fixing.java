package bg.softuni.java_oop.exception_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P03_Fixing {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] weekdays = new String[5];

        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        try {
            for (int i = 0; i <= weekdays.length; i++) {
                System.out.println(weekdays[i]);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
