package bg.softuni.java_advanced.multidimensional_arrays.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class E10RadioactiveMutantVampireBunnies {

    private static boolean isAlive = true;
    private static char[][] lairBoard;
    private static char[][] newLiarBoard;
    private static final int[] playerPosition = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        readMatrix(reader);
        char[] moves = reader.readLine().toCharArray();
        boolean inTheLiarBoard = true;
        int currentMove = 0;

        while (isAlive && inTheLiarBoard) {

            char move = moves[currentMove];
            int currentPlayerRow = playerPosition[0];
            int currentPlayerCol = playerPosition[1];
            newLiarBoard = new char[lairBoard.length][lairBoard[0].length];
            lairBoard[playerPosition[0]][playerPosition[1]] = '.';
            newLiarBoard[playerPosition[0]][playerPosition[1]] = '.';

            if (move == 'U') {
                currentPlayerRow--;
                inTheLiarBoard = 0 <= currentPlayerRow && checkMatrixRow(currentPlayerRow, currentPlayerCol);
            } else if (move == 'D') {
                currentPlayerRow++;
                inTheLiarBoard = currentPlayerRow < lairBoard.length && checkMatrixRow(currentPlayerRow, currentPlayerCol);
            } else if (move == 'L') {
                currentPlayerCol--;
                inTheLiarBoard = 0 <= currentPlayerCol && checkMatrixCol(currentPlayerRow, currentPlayerCol);
            } else if (move == 'R') {
                currentPlayerCol++;
                inTheLiarBoard = currentPlayerCol < lairBoard[0].length && checkMatrixCol(currentPlayerRow, currentPlayerCol);
            }
            fillTheBunnies();
            currentMove++;
        }

        printMatrix(lairBoard);

        if (inTheLiarBoard) {
            System.out.printf("dead: %d %d", playerPosition[0], playerPosition[1]);
        } else {
            System.out.printf("won: %d %d", playerPosition[0], playerPosition[1]);
        }
    }

    private static boolean checkMatrixCol(int currentPlayerRow, int currentPlayerCol) {
        if (lairBoard[currentPlayerRow][currentPlayerCol] == 'B') {
            isAlive = false;
            playerPosition[1] = currentPlayerCol;
        } else {
            playerPosition[1] = currentPlayerCol;
            newLiarBoard[playerPosition[0]][playerPosition[1]] = 'P';
        }
        return true;
    }

    private static boolean checkMatrixRow(int currentPlayerRow, int currentPlayerCol) {
        if (lairBoard[currentPlayerRow][currentPlayerCol] == 'B') {
            isAlive = false;
            playerPosition[0] = currentPlayerRow;
        } else {
            playerPosition[0] = currentPlayerRow;
            newLiarBoard[playerPosition[0]][playerPosition[1]] = 'P';
        }
        return true;
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        int[] size = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        lairBoard = new char[size[0]][size[1]];
        for (int row = 0; row < lairBoard.length; row++) {
            String input = reader.readLine();
            lairBoard[row] = input.toCharArray();
            if (input.contains("P")) {
                playerPosition[0] = row;
                playerPosition[1] = input.indexOf('P');
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix)
                .map(row -> Arrays.toString(row)
                .replaceAll("[\\[\\], ]", ""))
                .forEach(System.out::println);
    }

    private static void fillTheBunnies() {
        for (int i = 0; i < lairBoard.length; i++) {
            for (int j = 0; j < lairBoard[0].length; j++) {
                if (lairBoard[i][j] == 'B') {
                    newLiarBoard[i][j] = 'B';
                    if (0 <= i - 1) {
                        checkIsALive(i - 1, j);
                        newLiarBoard[i - 1][j] = 'B';
                    }
                    if (i + 1 < lairBoard.length) {
                        checkIsALive(i + 1, j);
                        newLiarBoard[i + 1][j] = 'B';
                    }
                    if (0 <= j - 1) {
                        checkIsALive(i, j - 1);
                        newLiarBoard[i][j - 1] = 'B';
                    }
                    if (j + 1 < lairBoard[0].length) {
                        checkIsALive(i, j + 1);
                        newLiarBoard[i][j + 1] = 'B';
                    }
                } else if (newLiarBoard[i][j] != 'P' && newLiarBoard[i][j] != 'B') {
                    newLiarBoard[i][j] = '.';
                }
            }
        }
        lairBoard = newLiarBoard;
    }

    private static void checkIsALive(int row, int col) {
        if (newLiarBoard[row][col] == 'P') {
            isAlive = false;
        }
    }
}
