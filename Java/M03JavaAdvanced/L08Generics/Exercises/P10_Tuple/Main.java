package bg.softuni.java_advanced.generics.exercises.P10_Tuple;

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

        Tuple<String, String> firstMap = new Tuple<>(name, address);
        System.out.println(firstMap);

        data = reader.readLine().split("\\s+");
        name = data[0];
        int litters = Integer.parseInt(data[1]);
        Tuple<String, Integer> secondMap = new Tuple<>(name, litters);
        System.out.println(secondMap);

        data = reader.readLine().split("\\s+");
        int intNum = Integer.parseInt(data[0]);
        double floatNum = Double.parseDouble(data[1]);
        Tuple<Integer, Double> lastMap = new Tuple<>(intNum, floatNum);
        System.out.println(lastMap);

    }

    private static String[] getData(BufferedReader reader) throws IOException {
        return reader.readLine().split("\\s+");
    }
}

