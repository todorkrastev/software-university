package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E05MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] rowsAndCols = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] intMatrix = readMatrix(reader, rows, cols);

        String input;
        while (!"END".equals(input = reader.readLine())) {
            boolean isValid = true;
            String[] split = input.trim().split("\\s+");
            String command = split[0];

            if (split.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            if ("swap".equals(command)) {
                int rowFirstEl = Integer.parseInt(split[1]);
                int colFirstEl = Integer.parseInt(split[2]);
                int rowSecondEl = Integer.parseInt(split[3]);
                int colSecondEl = Integer.parseInt(split[4]);

                boolean isInMatrix = 0 <= rowFirstEl && rowFirstEl < intMatrix.length && 0 <= colFirstEl && colFirstEl < intMatrix[0].length && 0 <= rowSecondEl && rowSecondEl < intMatrix.length && 0 <= colSecondEl && colSecondEl < intMatrix[0].length;

                if (isInMatrix) {
                    String temp = intMatrix[rowFirstEl][colFirstEl];
                    intMatrix[rowFirstEl][colFirstEl] = intMatrix[rowSecondEl][colSecondEl];
                    intMatrix[rowSecondEl][colSecondEl] = temp;

                    printMatrix(intMatrix);
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
            if (!isValid) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] intMatrix) {
        for (String[] matrix : intMatrix) {
            for (String element : matrix) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        String[][] intMatrix = new String[rows][cols];
        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = reader.readLine().trim().split("\\s+");
        }
        return intMatrix;
    }
}
