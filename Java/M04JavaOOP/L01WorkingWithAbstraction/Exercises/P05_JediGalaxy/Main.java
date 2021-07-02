package bg.softuni.java_oop.working_with_abstraction.exercises.P05_JediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    private static long playerPoints = 0;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] sizeOfMatrix = getDimensionOfMatrix(reader.readLine());
        fillMatrix(sizeOfMatrix);

        String command;
        while (!"Let the Force be with you".equals(command = reader.readLine())) {
            int[] playerStartIndex = getDimensionOfMatrix(command);
            int[] evilStartIndex = getDimensionOfMatrix(reader.readLine());
            evilStartMoving(evilStartIndex[0], evilStartIndex[1]);
            playerStartMoving(playerStartIndex[0], playerStartIndex[1]);
        }
        System.out.println(playerPoints);
    }

    private static void playerStartMoving(int row, int col) {
        while (row >= 0 && col < matrix[0].length) {
            if (row < matrix.length && col >= 0) {
                playerPoints += matrix[row][col];
            }
            col++;
            row--;
        }
    }

    private static void evilStartMoving(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[row].length) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private static void fillMatrix(int[] index) {
        matrix = new int[index[0]][index[1]];
        int value = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = value++;
            }
        }
    }

    private static int[] getDimensionOfMatrix(String input) {
        return Arrays
                .stream(input.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
