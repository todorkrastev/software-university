package bg.softuni.java_oop.interfaces_and_abstraction.lab.P06_Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String driversName = reader.readLine();
        Ferrari ferrari = new Ferrari(driversName);
        System.out.println(ferrari);
    }
}
