package bg.softuni.java_advanced.defining_classes.exercises.P09_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Cat> catsInfo = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.trim().split("\\s+");
            String breed = data[0];
            String name = data[1];
            double characteristic = Double.parseDouble(data[2]);

            switch (breed) {

                case "Siamese":
                    catsInfo.put(name, new Siamese(name, breed, characteristic));
                    break;
                case "StreetExtraordinaire":
                    catsInfo.put(name, new StreetExtraordinaire(name, breed, characteristic));
                    break;
                case "Cymric":
                    catsInfo.put(name, new Cymric(name, breed, characteristic));
                    break;
            }
        }
        System.out.println(catsInfo.get(reader.readLine()));
    }
}

