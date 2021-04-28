package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E03IntersectionOfTwoMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] firstMatrix = readMatrix(reader, rows, cols);
        char[][] secondMatrix = readMatrix(reader, rows, cols);


        char[][] intersectionMatrix = compareMatrices(firstMatrix, secondMatrix, rows, cols);
    }

    private static char[][] compareMatrices(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] charMatrix = new char[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                charMatrix[row][col] =
                        firstMatrix[row][col] == secondMatrix[row][col]
                                ? firstMatrix[row][col]
                                : '*';
                System.out.print(charMatrix[row][col] + " ");
            }
            System.out.println();
        }
        return charMatrix;
    }

    private static char[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        char[][] charMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] symbols = reader.readLine().trim().split("\\s+");
            for (int col = 0; col < cols; col++) {
                charMatrix[row][col] = symbols[col].charAt(0);
            }
        }
        return charMatrix;
    }
}