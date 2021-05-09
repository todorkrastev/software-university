package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class E06StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String rotation = reader.readLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        List<String> list = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;

        String input;
        while (!"END".equals(input = reader.readLine())) {
            list.add(input);

            if (maxLen < input.length()) {
                maxLen = input.length();
            }
        }

        int rows = list.size();
        int cols = maxLen;

        char[][] charMatrix = readMatrix(rows, cols, list);

        switch (angleRotation) {
            case 90:
                printAngleRotation90(charMatrix, rows, cols);
                break;
            case 180:
                printAngleRotation180(charMatrix, rows, cols);
                break;
            case 270:
                printAngleRotation270(charMatrix, rows, cols);
                break;
            case 0:
                printAngleRotation0(charMatrix, rows, cols);
                break;
            default:
                break;
        }
    }

    private static void printAngleRotation0(char[][] charMatrix, int rows, int cols) {
        for (int row = 0; row < charMatrix.length; row++) {
            for (int col = 0; col < charMatrix[row].length; col++) {
                printMatrix(charMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printAngleRotation270(char[][] charMatrix, int rows, int cols) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < charMatrix.length; row++) {
                printMatrix(charMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix(char charMatrix) {
        System.out.print(charMatrix);
    }

    private static void printAngleRotation180(char[][] charMatrix, int rows, int cols) {
        for (int row = charMatrix.length - 1; row >= 0; row--) {
            for (int col = charMatrix[row].length - 1; col >= 0; col--) {
                printMatrix(charMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printAngleRotation90(char[][] charMatrix, int rows, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                if (col < charMatrix[row].length) {
                    printMatrix(charMatrix[row][col]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int rows, int cols, List<String> list) {
        char[][] charMatrix = new char[rows][cols];
        for (int row = 0; row < charMatrix.length; row++) {
            for (int col = 0; col < charMatrix[row].length; col++) {
                if (col < list.get(row).length()) {
                    charMatrix[row][col] = list.get(row).charAt(col);
                } else {
                    charMatrix[row][col] = ' ';
                }
            }
        }
        return charMatrix;
    }
}