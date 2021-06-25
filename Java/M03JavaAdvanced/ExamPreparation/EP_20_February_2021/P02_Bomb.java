package bg.softuni.java_advanced.exam_preparation_20_February_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P02_Bomb {

    private static char[][] matrix;
    private static int row;
    private static int col;
    private static int[] previousPos = new int[2];


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfSquareMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfSquareMatrix][];
        ArrayDeque<String> directionsQueue = Arrays.stream(reader.readLine().trim().split(","))
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));
        readMatrix(reader);

        while (!directionsQueue.isEmpty() && !isLetterE()) {
            previousPos[0] = row;
            previousPos[1] = col;
            switch (directionsQueue.poll()) {
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
            if (isInBound()) {
                if (matrix[row][col] == 'B') {
                    System.out.println("You found a bomb!");
                    matrix[row][col] = '+';
                }
            } else {
                row = previousPos[0];
                col = previousPos[1];
            }
        }
        if (foundBombs() == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isLetterE()) {
            System.out.printf("END! %d bombs left on the field%n", foundBombs());
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", foundBombs(), row, col);
        }
    }

    private static int foundBombs() {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isLetterE() {
        return matrix[row][col] == 'e';
    }


    private static boolean isInBound() {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int r = 0; r < matrix.length; r++) {
            String input = reader.readLine().replaceAll("\\s+", "");
            matrix[r] = input.toCharArray();
            if (input.contains("s")) {
                row = r;
                col = input.indexOf('s');
            }
        }
    }
}
