package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[][] matrix = readMatrix(reader);
        String pattern = "^swap (\\d+) (\\d+) (\\d+) (\\d+)$";
        Pattern patternCompile = Pattern.compile(pattern);
        String input;

        while (!"END".equals(input = reader.readLine())) {
            boolean isValid = true;
            Matcher matcher = patternCompile.matcher(input);
            if (matcher.matches()) {
                int row1 = Integer.parseInt(matcher.group(1)), col1 = Integer.parseInt(matcher.group(2)),
                        row2 = Integer.parseInt(matcher.group(3)), col2 = Integer.parseInt(matcher.group(4));
                boolean isInMatrix = row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length
                        && col1 >= 0 && col1 < matrix[0].length && col2 >= 0 && col2 < matrix[0].length;
                if (isInMatrix) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    printMatrix(matrix);
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

    private static void printMatrix(String[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.printf("%s ", element));
            System.out.println();
        });
    }

    private static String[][] readMatrix(BufferedReader reader) throws IOException {
        int[] size = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            matrix[i] = reader.readLine().split("\\s+");
        }
        return matrix;
    }
}