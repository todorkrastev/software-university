package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class E08AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));


        int num = Integer.parseInt(reader.readLine());

        Map<String, double[]> map = new TreeMap<>();

        for (int i = 0; i < num; i++) {
            String name = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            map.putIfAbsent(name, grades);

        }
        map
                .forEach((k, v) -> System.out.printf("%s is graduated with %s%n", k, getAverage(v)));
    }

    private static double getAverage(double[] grades) {
        double average = 0.0;
        for (double grade : grades) {
            average += grade;
        }
        return average / grades.length;
    }
}
