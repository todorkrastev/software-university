package bg.softuni.java_advanced.preparation_exam_28_June_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P02_SnakeSecondOption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        char[][] matrix = readMatrix(reader, Integer.parseInt(reader.readLine()));
        int foodCounter = 0;
        int[] currPos = findIndexes(matrix, 'S');

        while (foodCounter < 10) {
            String input = reader.readLine();
            matrix[currPos[0]][currPos[1]] = '.';
            switch (input) {
                case "up":
                    currPos[0]--;
                    break;
                case "down":
                    currPos[0]++;
                    break;
                case "left":
                    currPos[1]--;
                    break;
                case "right":
                    currPos[1]++;
                    break;
            }
            if (isIndexInBounds(currPos, matrix)) {
                if (matrix[currPos[0]][currPos[1]] == '*') {
                    foodCounter++;
                    matrix[currPos[0]][currPos[1]] = 'S';
                } else if (matrix[currPos[0]][currPos[1]] == 'B') {
                    matrix[currPos[0]][currPos[1]] = '.';
                    currPos = findIndexes(matrix, 'B');
                }
            } else {
                break;
            }
        }
        if (foodCounter < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodCounter);

        printMatrix(matrix);

    }

    private static boolean isIndexInBounds(int[] currentPosition, char[][] territory) {
        return currentPosition[0] >= 0 && currentPosition[0] < territory.length
                && currentPosition[1] >= 0 && currentPosition[1] < territory.length;
    }

    private static int[] findIndexes(char[][] matrix, char toFind) {
        int[] indexes = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == toFind) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }

    private static char[][] readMatrix(BufferedReader reader, int n) throws IOException {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().trim().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }
}
