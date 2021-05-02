package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E07FindTheRealQueen {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        char[][] charMatrix = readMatrix(reader);
        findTheRealQueen(charMatrix);
    }

    private static void findTheRealQueen(char[][] charMatrix) {
        for (int row = 0; row < charMatrix.length; row++) {
            for (int col = 0; col < charMatrix[row].length; col++) {
                if (checkCurrentChar(charMatrix, row, col, charMatrix[row][col])) {
                    System.out.println(row + " " + col);
                }
            }
        }
    }

    private static boolean checkCurrentChar(char[][] charMatrix, int row, int col, char currSymbol) {
        return checkRow(charMatrix, row, col, currSymbol) && checkCol(charMatrix, row, col, currSymbol) && checkDiagonals(charMatrix, row, col, currSymbol);

    }

    private static boolean checkDiagonals(char[][] charMatrix, int row, int col, char currSymbol) {
        int rows = row + 1;
        int cols = col + 1;

        while (rows < charMatrix.length && cols < charMatrix[rows].length) {
            if (charMatrix[rows++][cols++] == currSymbol) {
                return false;
            }
        }
        rows = row - 1;
        cols = col - 1;
        while (rows >= 0 && cols >= 0) {
            if (charMatrix[rows--][cols--] == currSymbol) {
                return false;
            }
        }
        rows = row - 1;
        cols = col + 1;
        while (rows >= 0 && cols < charMatrix[rows].length) {
            if (charMatrix[rows--][cols++] == currSymbol) {
                return false;
            }
        }
        rows = row + 1;
        cols = col - 1;
        while (rows < charMatrix.length && cols >= 0) {
            if (charMatrix[rows++][cols--] == currSymbol) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(char[][] matrix, int row, int col, char currSymbol) {
        if (row > 0) {
            for (int currRow = 0; currRow < row; currRow++) {
                if (matrix[currRow][col] == currSymbol) {
                    return false;
                }
            }
        }
        if (row + 1 < matrix.length) {
            for (int currRow = row + 1; currRow < matrix.length; currRow++) {
                if (matrix[currRow][col] == currSymbol) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow(char[][] matrix, int row, int col, char currSymbol) {
        if (col > 0) {
            for (int currCol = 0; currCol < col; currCol++) {
                if (matrix[row][currCol] == currSymbol) {
                    return false;
                }
            }
        }
        if (col + 1 < matrix[row].length) {
            for (int currCol = col + 1; currCol < matrix[row].length; currCol++) {
                if (matrix[row][currCol] == currSymbol) {
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] readMatrix(BufferedReader reader) throws IOException {
        char[][] charMatrix = new char[8][8];
        for (int row = 0; row < charMatrix.length; row++) {
            charMatrix[row] = readArray(reader);
        }
        return charMatrix;
    }

    private static char[] readArray(BufferedReader reader) throws IOException {
        return reader.readLine().trim().replaceAll("\\s+", "").toCharArray();
    }
}