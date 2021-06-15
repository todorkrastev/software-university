package bg.softuni.java_advanced.preparation_exam_16_12_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P02_Selling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        //Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]

        //Diagonals
//[row++] [col++]
//[row--] [col--]
//[row++] [col--]
//[row--] [col++]

        int sizeOfMatrix = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().replaceAll("\\s+", "").toCharArray();
        }

        int[] startPosition = getStartingPosition(matrix, 'S');
        int row = startPosition[0];
        int col = startPosition[1];

        int bankAccount = 0;
        while (bankAccount < 50) {
            String command = reader.readLine();
            matrix[row][col] = '-';

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
                default:
                    break;
            }
            if (isInBounds(matrix, row, col)) {
                if (Character.isDigit(matrix[row][col])) {
                    bankAccount += Integer.parseInt(String.valueOf(matrix[row][col]));
                    matrix[row][col] = 'S';
                } else if (matrix[row][col] == 'O') {
                    matrix[row][col] = '-';
                    startPosition = getStartingPosition(matrix, 'O');
                    row = startPosition[0];
                    col = startPosition[1];
                }
            } else {
                break;
            }
        }
        if (50 <= bankAccount) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + bankAccount);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix)
                .map(row -> Arrays.toString(row)
                        .replaceAll("[\\[\\]]", "").replaceAll("[, ]", ""))
                .forEach(System.out::println);
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix.length;
    }

    private static int[] getStartingPosition(char[][] matrix, char chToFind) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == chToFind) {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }
}
