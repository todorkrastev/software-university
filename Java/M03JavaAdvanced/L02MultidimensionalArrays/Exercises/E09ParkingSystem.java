package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E09ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] rowsAndCols = reader.readLine().trim().split("\\s+");

        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        boolean[][] isOccupied = new boolean[rows][cols];

        for (int i = 0; i < isOccupied.length; i++) {
            isOccupied[i][0] = true;
        }

        String input;
        while (!"stop".equals(input = reader.readLine())) {
            String[] split = input.trim().split("\\s+");
            int entryRow = Integer.parseInt(split[0]);
            int targetRow = Integer.parseInt(split[1]);
            int targetCol = Integer.parseInt(split[2]);
            boolean hasFoundFreePlace = false;

            int traveledDistance = 1;

            traveledDistance += Math.abs(targetRow - entryRow);

            if (!isOccupied[targetRow][targetCol]) {
                traveledDistance += targetCol;
                isOccupied[targetRow][targetCol] = true;
                hasFoundFreePlace = true;
            } else {
                for (int i = 1; i < isOccupied[targetRow].length; i++) {
                    if (0 < targetCol - i && !isOccupied[targetRow][targetCol - i]) {
                        isOccupied[targetRow][targetCol - i] = true;
                        hasFoundFreePlace = true;
                        traveledDistance += targetCol - i;
                        break;
                    }
                    if (targetCol + i < isOccupied[targetRow].length && !isOccupied[targetRow][targetCol + i]) {
                        isOccupied[targetRow][targetCol + i] = true;
                        hasFoundFreePlace = true;
                        traveledDistance += targetCol + i;
                        break;
                    }
                }
            }

            if (hasFoundFreePlace) {
                System.out.println(traveledDistance);
            } else {
                System.out.printf("Row %d full%n", targetRow);
            }
        }
    }
}
