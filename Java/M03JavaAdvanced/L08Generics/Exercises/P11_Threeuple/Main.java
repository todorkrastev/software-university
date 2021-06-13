package bg.softuni.java_advanced.generics.exercises.P11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] data = getData(reader);
        String name = String.format("%s %s", data[0], data[1]);
        String address = data[2];
        String city = data[3];

        Threeuple<String, String, String> firstMap = new Threeuple<>(name, address, city);
        System.out.println(firstMap);

        data = getData(reader);
        name = data[0];
        int litters = Integer.parseInt(data[1]);
        boolean isDrunk = "drunk".equals(data[2]);

        Threeuple<String, Integer, Boolean> secondMap = new Threeuple<>(name, litters, isDrunk);
        System.out.println(secondMap);

        data = getData(reader);
        name = data[0];
        double amount = Double.parseDouble(data[1]);
        String bank = data[2];

        Threeuple<String, Double, String> lastMap = new Threeuple<>(name, amount, bank);
        System.out.println(lastMap);
    }

    private static String[] getData(BufferedReader reader) throws IOException {
        return reader.readLine().trim().split("\\s+");
    }
}
