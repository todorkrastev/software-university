package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E12TheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        char[][] matrix = readMatrix(reader);
        char charToFill = reader.readLine().charAt(0);
        int[] startCoordinates = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        char startChar = matrix[startCoordinates[0]][startCoordinates[1]];
        matrix[startCoordinates[0]][startCoordinates[1]] = charToFill;

        fillMatrix(matrix, startCoordinates[0], startCoordinates[1], startChar, charToFill);
        printMatrix(matrix);
    }

    private static char[][] readMatrix(BufferedReader reader) throws IOException {
        int[] size = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        char[][] matrix = new char[size[0]][size[1]];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix)
                .map(row -> Arrays.toString(row)
                        .replaceAll("[\\[\\]]", "")
                .replaceAll(", ", ""))
                .forEach(System.out::println);
    }

    private static void fillMatrix(char[][] matrix, int row, int col, char startChar, char fillChar) {
        if (row + 1 < matrix.length && matrix[row + 1][col] == startChar) {
            matrix[row + 1][col] = fillChar;
            fillMatrix(matrix, row + 1, col, startChar, fillChar);
        }
        if (0 <= row - 1 && matrix[row - 1][col] == startChar) {
            matrix[row - 1][col] = fillChar;
            fillMatrix(matrix, row - 1, col, startChar, fillChar);
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] == startChar) {
            matrix[row][col + 1] = fillChar;
            fillMatrix(matrix, row, col + 1, startChar, fillChar);
        }
        if (0 <= col - 1 && matrix[row][col - 1] == startChar) {
            matrix[row][col - 1] = fillChar;
            fillMatrix(matrix, row, col - 1, startChar, fillChar);
        }
    }
}
