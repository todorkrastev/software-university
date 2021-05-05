package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E02MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] rowsAndCols = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] strMatrix = new String[rows][cols];

        fillMatrix(strMatrix);
    }

    private static void fillMatrix(String[][] strMatrix) {
        char initialCh = 'a';
        for (int row = 0; row < strMatrix.length; row++) {
            for (int col = 0; col < strMatrix[row].length; col++) {
                char[] palindrome = {(char) (initialCh + row), (char) (initialCh + row + col), (char) (initialCh + row)};
                strMatrix[row][col] = new String(palindrome);
                System.out.print(strMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
