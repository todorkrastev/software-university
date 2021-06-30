package bg.softuni.java_oop.working_with_abstraction.lab.P02_PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] coordinates = getCoordinates(reader);

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];


        Rectangle rectangle = new Rectangle(
                new Point(bottomLeftX, bottomLeftY),
                new Point(topRightX, topRightY));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            coordinates = getCoordinates(reader);

            boolean contains = rectangle.contains(new Point(coordinates[0], coordinates[1]));

            System.out.println(contains);
        }
    }

    private static int[] getCoordinates(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

