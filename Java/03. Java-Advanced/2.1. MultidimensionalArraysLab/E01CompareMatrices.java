package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01CompareMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

         int[][] firstMatrix = readMatrix(reader);
         int[][] secondMatrix = readMatrix(reader);

         boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        String[] dimension = reader.readLine().trim().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] line = reader.readLine().trim().split("\\s+");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = Integer.parseInt(line[c]);
            }
        }

        return matrix;
    }
}
