package bg.softuni.java_advanced.exam_preparation_23_October_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P01_TheGarden {
    private static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        final int numOfRows = Integer.parseInt(reader.readLine());
        matrix = new char[numOfRows][];

        readMatrix(reader);

        int countCarrots = 0;
        int countPotatoes = 0;
        int countLettuce = 0;
        int countHarmedVegetables = 0;
        String input;
        while (!"End of Harvest".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Harvest":
                    if (isInBounds(row, col) && !Character.isWhitespace(matrix[row][col])) {
                        if (matrix[row][col] == 'L') {
                            countLettuce++;
                        } else if (matrix[row][col] == 'P') {
                            countPotatoes++;
                        } else if (matrix[row][col] == 'C') {
                            countCarrots++;
                        }
                        matrix[row][col] = ' ';
                    }
                    break;
                case "Mole":
                    String direction = tokens[3];
                    switch (direction) {
                        //Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]
                        case "up":
                            while (isInBounds(row, col)) {
                                if (!Character.isWhitespace(matrix[row][col])) {
                                    matrix[row][col] = ' ';
                                    countHarmedVegetables++;
                                }
                                row -= 2;
                            }
                            break;
                        case "down":
                            while (isInBounds(row, col)) {
                                if (!Character.isWhitespace(matrix[row][col])) {
                                    matrix[row][col] = ' ';
                                    countHarmedVegetables++;
                                }
                                row += 2;
                            }
                            break;
                        case "left":
                            while (isInBounds(row, col)) {
                                if (!Character.isWhitespace(matrix[row][col])) {
                                    matrix[row][col] = ' ';
                                    countHarmedVegetables++;
                                }
                                col -= 2;
                            }
                            break;
                        case "right":
                            while (isInBounds(row, col)) {
                                if (!Character.isWhitespace(matrix[row][col])) {
                                    matrix[row][col] = ' ';
                                    countHarmedVegetables++;
                                }
                                col += 2;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        printMatrix();
        System.out.printf("Carrots: %d%n", countCarrots);
        System.out.printf("Potatoes: %d%n", countPotatoes);
        System.out.printf("Lettuce: %d%n", countLettuce);
        System.out.printf("Harmed vegetables: %d%n", countHarmedVegetables);
    }


    private static boolean isInBounds(int row, int col) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static void printMatrix() {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
