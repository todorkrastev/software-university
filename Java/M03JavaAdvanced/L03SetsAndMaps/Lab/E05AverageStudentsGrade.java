package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class E05AverageStudentsGrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int numOfStudents = Integer.parseInt(reader.readLine());

        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i < numOfStudents; i++) {
            String[] input = reader.readLine().trim().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(grade);
        }
        map
                .forEach((key, value) -> {
                    System.out.printf("%s -> ", key);
                    value
                            .forEach(v -> System.out.printf("%.2f ", v));
                    System.out.printf("(avg: %.2f)%n", getAverage(value));
                });
    }

    private static Double getAverage(List<Double> value) {
        double average = 0.0;
        for (Double aDouble : value) {
            average += aDouble;
        }
        return average / value.size();
    }
}
