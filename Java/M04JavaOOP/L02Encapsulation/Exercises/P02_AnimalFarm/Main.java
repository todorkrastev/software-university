package bg.softuni.java_oop.encapsulation.exercises.P02_AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Chicken chicken = new Chicken(name, age);

        System.out.println(chicken);
    }
}
