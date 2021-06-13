package bg.softuni.java_advanced.multidimensional_arrays.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E02MatrixOfPalindromesSecondOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] input = Arrays.stream(reader.readLine().trim().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        String[][] matrix = new String[input[0]][input[1]];

        fillMatrix(matrix);

        Arrays.stream(matrix).forEach(r -> {
            Arrays.stream(r).forEach(e -> System.out.print(e + " "));
            System.out.println();
        });
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.format("%c%c%c", 97 + row, 97 + row + col, 97 + row);
            }
        }
    }
}
