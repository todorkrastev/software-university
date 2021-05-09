package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class E11ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] intMatrix = readMatrix(reader);

        int currRow = intMatrix.length - 1;
        int currCol = intMatrix[currRow].length - 1;

        while (0 <= currCol) {
            printDiagonals(currCol, currRow, intMatrix);
            if (currCol == 0) {
                currRow--;
                while (currRow >= 0) {
                    printDiagonals(currCol, currRow, intMatrix);
                    currRow--;
                }
            }
            currCol--;
        }
    }

    private static void printDiagonals(int currCol, int curRow, int[][] intMatrix) {
        int increaseCol = 0;
        for (int i = curRow; i >= 0; i--) {
            if ((currCol + increaseCol < intMatrix[curRow].length)) {
                System.out.printf("%d ", intMatrix[i][currCol + increaseCol]);
            } else {
                break;
            }
            increaseCol++;
        }
        System.out.println();
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        int[] rowsAndCols = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] intMatrix = new int[rows][cols];

        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return intMatrix;
    }
}