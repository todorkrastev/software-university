package bg.softuni.java_advanced.exam_preparation_19_August_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P02_Bee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfMatrix = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        readMatrix(reader, matrix);

        int[] indexRowAndCol = findLetterB(matrix);
        int row = indexRowAndCol[0];
        int col = indexRowAndCol[1];


        //Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]
        int pollinatedFlowers = 0;
        String command;
        while (!"End".equals(command = reader.readLine())) {
            matrix[row][col] = '.';

            switch (command) {
                case "up":
                    row--;
                    if (isLetter(matrix, row, col, 'O')) {
                        row--;
                    }
                    break;
                case "down":
                    row++;
                    if (isLetter(matrix, row, col, 'O')) {
                        row++;
                    }
                    break;
                case "left":
                    col--;
                    if (isLetter(matrix, row, col, 'O')) {
                        col--;
                    }
                    break;
                case "right":
                    col++;
                    if (isLetter(matrix, row, col, 'O')) {
                        col++;
                    }
                    break;
                default:
                    break;
            }
            if (isInBounds(matrix, row, col)) {
                if (isLetter(matrix, row, col, 'f')) {
                    pollinatedFlowers++;
                }
            } else {
                System.out.println("The bee got lost!");
                break;
            }
            matrix[row][col] = 'B';
        }

        if (pollinatedFlowers < 5) {
            int diff = 5 - pollinatedFlowers;
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", diff);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        print(matrix);
    }

    private static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static boolean isLetter(char[][] matrix, int row, int col, char letterToFind) {
        if (isInBounds(matrix, row, col) && matrix[row][col] == letterToFind) {
            matrix[row][col] = '.';
            return true;
        }
        return false;
    }

    private static int[] findLetterB(char[][] matrix) {
        int[] indexRowAndCol = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    indexRowAndCol[0] = row;
                    indexRowAndCol[1] = col;
                }
            }
        }
        return indexRowAndCol;
    }

    private static void readMatrix(BufferedReader reader, char[][] matrix) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
