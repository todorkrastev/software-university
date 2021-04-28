package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfMatrix = Integer.parseInt(reader.readLine());

        int[][] intMatrix = readMatrix(reader, sizeOfMatrix);

        findFirstDiagonal(intMatrix);
        System.out.println();
        findSecondDiagonal(intMatrix);
    }

    private static void findSecondDiagonal(int[][] intMatrix) {
        int row = intMatrix.length - 1;
        int col = 0;

        while (col != intMatrix.length) {
            System.out.print(intMatrix[row][col] + " ");
            row--;
            col++;
        }
    }

    private static void findFirstDiagonal(int[][] intMatrix) {
        int row = 0;
        int col = 0;

        while (row != intMatrix.length) {
            System.out.print(intMatrix[row][col] + " ");
            row++;
            col++;
        }
    }

    private static int[][] readMatrix(BufferedReader reader, int sizeOfMatrix) throws IOException {
        int[][] intMatrix = new int[sizeOfMatrix][];

        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return intMatrix;
    }
}