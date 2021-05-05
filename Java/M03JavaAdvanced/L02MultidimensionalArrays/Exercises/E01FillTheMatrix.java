package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] input = reader.readLine().trim().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] intMatrix = fillMatrix(size, pattern);
        printMatrix(intMatrix);
    }

    private static void printMatrix(int[][] intMatrix) {
        for (int[] row : intMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int size, String pattern) {
        int[][] intMatrix = new int[size][size];

        if ("A".equals(pattern)) {
            fillPatternA(intMatrix, size);
        } else if ("B".equals(pattern)) {
            fillPatternB(intMatrix, size);
        }
        return intMatrix;
    }

    private static void fillPatternB(int[][] intMatrix, int size) {
        int digit = 1;

        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    intMatrix[row][col] = digit++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    intMatrix[row][col] = digit++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] intMatrix, int size) {
        int digit = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                intMatrix[row][col] = digit++;
            }
        }
    }
}
