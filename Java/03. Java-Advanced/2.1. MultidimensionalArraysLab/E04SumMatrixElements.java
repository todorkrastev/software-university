package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E04SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in, StandardCharsets.UTF_8));

        int[] rowsAndCols = Arrays.stream(reader.readLine().trim().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];


        int[][] intMatrix = readMatrix(reader, rows, cols);
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getSum(intMatrix));
    }

    private static int getSum(int[][] intMatrix) {
        int sum = 0;

        for (int row = 0; row < intMatrix.length; row++) {
            for (int col = 0; col < intMatrix[row].length; col++) {
                sum += intMatrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        int[][] intMatrix = new int[rows][cols];

        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return intMatrix;
    }
}