package bg.softuni.java_advanced.exam_preparation_19_August_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P02_BeeSecondOption {
    static int beeRow, beeCol;
    static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        readMatrix(reader);
        int neededFlowers = 0;
        String input;

        while (!"End".equals(input = reader.readLine())) {

            matrix[beeRow][beeCol] = '.';

            switch (input) {
                case "right":
                    beeCol++;
                    checkForBonus(1, "col");
                    break;
                case "left":
                    beeCol--;
                    checkForBonus(-1, "col");
                    break;
                case "down":
                    beeRow++;
                    checkForBonus(1, "row");
                    break;
                case "up":
                    beeRow--;
                    checkForBonus(-1, "row");
                    break;
            }
            if (indexesInBounds()) {
                if (matrix[beeRow][beeCol] == 'f') {
                    neededFlowers++;
                }
            } else {
                System.out.println("The bee got lost!");
                break;
            }
            matrix[beeRow][beeCol] = 'B';
        }
        if (neededFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - neededFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", neededFlowers);
        }
        printMatrix();
    }

    private static void checkForBonus(int i, String dir) {
        while (indexesInBounds() && matrix[beeRow][beeCol] == 'O') {
            matrix[beeRow][beeCol] = '.';
            if (dir.equals("col")) {
                beeCol = Math.abs(beeCol) + i;
            } else {
                beeRow = Math.abs(beeRow) + i;
            }
        }
    }

    private static boolean indexesInBounds() {
        return (beeRow >= 0 && beeRow < matrix.length) && (beeCol >= 0 && beeCol < matrix[beeRow].length);
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String input = reader.readLine();
            matrix[row] = input.toCharArray();
            if (input.contains("B")) {
                beeRow = row;
                beeCol = input.indexOf('B');
            }
        }
    }

    private static void printMatrix() {
        Arrays.stream(matrix).map(row -> Arrays.toString(row)
                .replaceAll("[\\[\\], ]", "")).forEach(System.out::println);
    }
}
