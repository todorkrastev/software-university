package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E03DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int size = Integer.parseInt(reader.readLine());

        int[][] intMatrix = readMatrix(size, reader);
        System.out.println(findDifference(intMatrix));
    }

    private static int findDifference(int[][] intMatrix) {
        int first = findPrimaryDiagonal(intMatrix);
        int second = findSecondaryDiagonal(intMatrix);

        return Math.abs(first - second);
    }

    private static int findSecondaryDiagonal(int[][] intMatrix) {
        int row = intMatrix.length - 1;
        int col = 0;

        int sum = 0;
        while (col < intMatrix.length && 0 <= row) {
            sum += intMatrix[row][col];
            row--;
            col++;
        }
        return sum;
    }

    private static int findPrimaryDiagonal(int[][] intMatrix) {
        int row = 0;
        int col = 0;

        int sum = 0;

        while (row < intMatrix.length && col < intMatrix.length) {
            sum += intMatrix[row][col];
            row++;
            col++;
        }
        return sum;
    }

    private static int[][] readMatrix(int size, BufferedReader reader) throws IOException {
        int[][] intMatrix = new int[size][size];
        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return intMatrix;
    }
}
