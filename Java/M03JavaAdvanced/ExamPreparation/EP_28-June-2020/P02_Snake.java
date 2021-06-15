package bg.softuni.java_advanced.preparation_exam_28_June_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P02_Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfMatrix = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];
        fillMatrix(reader, matrix);

        int currPosRow = 0;
        int currPosCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("S")) {
                    currPosRow = row;
                    currPosCol = col;
                    break;
                }
            }
        }

        boolean isOutOfBounds = false;
        boolean isSnakeFed = false;
        int foodCounter = 0;
        while (!isOutOfBounds) {
            String command = reader.readLine();

            switch (command) {
                case "up":
                    currPosRow--;
                    if (0 <= currPosRow && !matrix[currPosRow][currPosCol].equals("B")) {
                        foodCounter = getFoodCounter(matrix, currPosRow, currPosCol, foodCounter);
                        if (foodCounter == 10) {
                            isSnakeFed = true;
                        }
                        matrix[currPosRow + 1][currPosCol] = ".";
                        matrix[currPosRow][currPosCol] = ".";
                    } else if (0 <= currPosRow && matrix[currPosRow][currPosCol].equals("B")) {
                        matrix[currPosRow][currPosCol] = ".";
                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix[row].length; col++) {
                                if (matrix[row][col].equals("B")) {
                                    matrix[row][col] = ".";
                                    currPosRow = row;
                                    currPosCol = col;
                                    break;
                                }
                            }
                        }
                    } else {
                        currPosRow++;
                        matrix[currPosRow][currPosCol] = ".";
                        isOutOfBounds = true;
                    }
                    break;
                case "down":
                    currPosRow++;
                    if (currPosRow <= sizeOfMatrix - 1 && !matrix[currPosRow][currPosCol].equals("B")) {
                        foodCounter = getFoodCounter(matrix, currPosRow, currPosCol, foodCounter);
                        if (foodCounter == 10) {
                            isSnakeFed = true;
                        }
                        matrix[currPosRow - 1][currPosCol] = ".";
                        matrix[currPosRow][currPosCol] = ".";
                    } else if (currPosRow <= sizeOfMatrix - 1 && matrix[currPosRow][currPosCol].equals("B")) {
                        matrix[currPosRow][currPosCol] = ".";
                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix[row].length; col++) {
                                if (matrix[row][col].equals("B")) {
                                    matrix[row][col] = ".";
                                    currPosRow = row;
                                    currPosCol = col;
                                    break;
                                }
                            }
                        }
                    } else {
                        currPosRow--;
                        matrix[currPosRow][currPosCol] = ".";
                        isOutOfBounds = true;
                    }
                    break;
                case "left":
                    currPosCol--;
                    if (0 <= currPosCol && !matrix[currPosRow][currPosCol].equals("B")) {
                        foodCounter = getFoodCounter(matrix, currPosRow, currPosCol, foodCounter);
                        if (foodCounter == 10) {
                            isSnakeFed = true;
                        }
                        matrix[currPosRow][currPosCol + 1] = ".";
                        matrix[currPosRow][currPosCol] = ".";
                    } else if (0 <= currPosCol && matrix[currPosRow][currPosCol].equals("B")) {
                        matrix[currPosRow][currPosCol] = ".";
                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix[row].length; col++) {
                                if (matrix[row][col].equals("B")) {
                                    matrix[row][col] = ".";
                                    currPosRow = row;
                                    currPosCol = col;
                                    break;
                                }
                            }
                        }
                    } else {
                        currPosCol++;
                        matrix[currPosRow][currPosCol] = ".";
                        isOutOfBounds = true;
                    }
                    break;
                case "right":
                    currPosCol++;
                    if (currPosCol <= sizeOfMatrix - 1 && !matrix[currPosRow][currPosCol].equals("B")) {
                        foodCounter = getFoodCounter(matrix, currPosRow, currPosCol, foodCounter);
                        if (foodCounter == 10) {
                            isSnakeFed = true;
                        }
                        matrix[currPosRow][currPosCol - 1] = ".";
                        matrix[currPosRow][currPosCol] = ".";
                    } else if (currPosCol <= sizeOfMatrix - 1 && matrix[currPosRow][currPosCol].equals("B")) {
                        matrix[currPosRow][currPosCol] = ".";
                        for (int row = 0; row < matrix.length; row++) {
                            for (int col = 0; col < matrix[row].length; col++) {
                                if (matrix[row][col].equals("B")) {
                                    matrix[row][col] = ".";
                                    currPosRow = row;
                                    currPosCol = col;
                                    break;
                                }
                            }
                        }
                    } else {
                        currPosCol--;
                        matrix[currPosRow][currPosCol] = ".";
                        isOutOfBounds = true;
                    }
                    break;
                default:
                    break;
            }
            if (isSnakeFed) {
                System.out.println("You won! You fed the snake.");
                matrix[currPosRow][currPosCol] = "S";
                break;
            }
        }
        if (isOutOfBounds) {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + foodCounter);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static int getFoodCounter(String[][] matrix, int currPosRow, int currPosCol, int foodCounter) {
        if (matrix[currPosRow][currPosCol].equals("*")) {
            foodCounter++;
        }
        return foodCounter;
    }


    private static void fillMatrix(BufferedReader reader, String[][] matrix) throws IOException {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = reader.readLine().trim().split("");
        }
    }
}
