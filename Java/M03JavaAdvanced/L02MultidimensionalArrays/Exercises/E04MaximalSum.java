package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E04MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] rowsAndCols = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] intMatrix = readMatrix(reader, rows, cols);
        getSum(intMatrix);
    }

    private static void getSum(int[][] intMatrix) {
        int startRow = 0;
        int startCol = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < intMatrix.length - 2; row++) {
            for (int col = 0; col < intMatrix[row].length - 2; col++) {
                int currSum = intMatrix[row][col] + intMatrix[row][col + 1] + intMatrix[row][col + 2] + intMatrix[row + 1][col] + intMatrix[row + 1][col + 1] + intMatrix[row + 1][col + 2] + intMatrix[row + 2][col] + intMatrix[row + 2][col + 1] + intMatrix[row + 2][col + 2];

                if (maxSum < currSum) {
                    maxSum = currSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        printElements(intMatrix, startRow, startCol);
    }

    private static void printElements(int[][] intMatrix, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(intMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        int[][] intMatrix = new int[rows][cols];
        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return intMatrix;
    }
}
