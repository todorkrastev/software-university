package bg.softuni.java_advanced.exam_preparation_14_April_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P02_CookingJourney {

    private static char[][] matrix;
    private static int row;
    private static int col;
    private static int bankAccount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfSquareMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfSquareMatrix][];
        readMatrix(reader);


        while (isInBounds() && bankAccount < 50) {
            matrix[row][col] = '-';
            String command = reader.readLine();
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
            if (isInBounds()) {
                if (isDigit()) {
                    bankAccount += Integer.parseInt(String.valueOf(matrix[row][col]));
                } else if (isLetterP()) {
                    int[] currPos = moveToOtherPillar();
                    row = currPos[0];
                    col = currPos[1];
                }
            }
        }
        if (!isInBounds()) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            matrix[row][col] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + bankAccount);
        printMatrix();
    }

    private static boolean isDigit() {
        return Character.isDigit(matrix[row][col]);
    }

    private static int[] moveToOtherPillar() {
        int[] newPos;
        matrix[row][col] = '-';
        newPos = findLetterP();
        return newPos;
    }

    private static int[] findLetterP() {
        int[] rowsAndCols = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    rowsAndCols[0] = row;
                    rowsAndCols[1] = col;
                }
            }
        }
        return rowsAndCols;
    }

    private static boolean isLetterP() {
        return matrix[row][col] == 'P';
    }

    private static boolean isInBounds() {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static void printMatrix() {
        Arrays.stream(matrix)
                .map(currRow -> Arrays.toString(currRow)
                        .replaceAll("[\\[\\]]", "")
                        .replaceAll(", ", ""))
                .forEach(System.out::println);
    }

    private static void readMatrix(BufferedReader reader) {
        IntStream
                .range(0, matrix.length)
                .forEach(currRow -> {
                    String input = null;
                    try {
                        input = reader.readLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    assert input != null;
                    if (input.contains("S")) {
                        row = currRow;
                        col = input.indexOf('S');
                    }
                    matrix[currRow] = input.toCharArray();
                });
    }
}
