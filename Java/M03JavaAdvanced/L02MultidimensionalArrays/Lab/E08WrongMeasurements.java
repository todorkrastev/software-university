package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E08WrongMeasurements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int rows = Integer.parseInt(reader.readLine());

        int[][] intMatrix = readMatrix(reader, rows);

        int[] input = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = input[0];
        int col = input[1];

        int wrongValue = intMatrix[row][col];
        int sum = 0;

        findTheWrongValue(intMatrix, wrongValue, sum);
    }

    private static void findTheWrongValue(int[][] intMatrix, int wrongValue, int sum) {
        for (int row = 0; row < intMatrix.length; row++) {
            for (int col = 0; col < intMatrix[row].length; col++) {
                if (intMatrix[row][col] != wrongValue) {
                    System.out.print(intMatrix[row][col] + " ");
                } else if (intMatrix[row][col] == wrongValue) {
                    sum += getUp(intMatrix, row, col, wrongValue);
                    sum += getDown(intMatrix, row, col, wrongValue);
                    sum += getRight(intMatrix, row, col, wrongValue);
                    sum += getLeft(intMatrix, row, col, wrongValue);
                    System.out.print(sum + " ");
                    sum = 0;
                }
                if (col == intMatrix[row].length - 1) {
                    System.out.println();
                }
            }
        }
    }

    private static int getLeft(int[][] intMatrix, int row, int col, int wrongValue) {
        int sum;
        if (0 < row) {
            row--;
            sum = compare(intMatrix, wrongValue, row, col);
        } else {
            sum = 0;
        }
        return sum;
    }

    private static int compare(int[][] intMatrix, int wrongValue, int row, int col) {
        int sum;
        if (intMatrix[row][col] != wrongValue) {
            sum = intMatrix[row][col];
        } else {
            sum = 0;
        }
        return sum;
    }

    private static int getRight(int[][] intMatrix, int row, int col, int wrongValue) {
        int sum;
        if (row != intMatrix.length - 1) {
            row++;
            sum = compare(intMatrix, wrongValue, row, col);
        } else {
            sum = 0;
        }
        return sum;
    }

    private static int getDown(int[][] intMatrix, int row, int col, int wrongValue) {
        int sum;
        if (col != intMatrix[row].length - 1) {
            col++;
            sum = compare(intMatrix, wrongValue, row, col);
        } else {
            sum = 0;
        }
        return sum;
    }


    private static int getUp(int[][] intMatrix, int row, int col, int wrongValue) {
        int sum;
        if (0 < col) {
            col--;
            sum = compare(intMatrix, wrongValue, row, col);
        } else {
            sum = 0;
        }
        return sum;
    }

    private static int[][] readMatrix(BufferedReader reader, int rows) throws IOException {
        int[][] intMatrix = new int[rows][];

        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return intMatrix;
    }
}