package bg.softuni.java_advanced.exam_preparation_26_October_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P02_BookWorm {
    private static char[][] matrix;
    private static int row;
    private static int col;
    private static char previousPos;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String initialStr = reader.readLine();
        int sizeOfMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfMatrix][sizeOfMatrix];
        readMatrix(reader);

        int[] rowsAndCols = getInitialPosition(matrix);
        row = rowsAndCols[0];
        col = rowsAndCols[1];

        StringBuilder output = new StringBuilder();
        output.append(initialStr);
        String command;
        while (!"end".equals(command = reader.readLine())) {
            previousPos = matrix[row][col];
            matrix[row][col] = '-';
            //Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]
            switch (command) {
                case "up":
                    moveToRow(-1, output);
                    break;
                case "down":
                    moveToRow(+1, output);
                    break;
                case "right":
                    moveToCol(+1, output);
                    break;
                case "left":
                    moveToCol(-1, output);
            }
            matrix[row][col] = 'P';
        }
        System.out.println(output);
        printMatrix();
    }

    private static void moveToCol(int i, StringBuilder output) {
        if (isInBounds(col + i)) {
            col += i;
            if (Character.isLetter(matrix[row][col])) {
                output.append(matrix[row][col]);
            }
        } else {
            outOfBounds(output, previousPos);
        }
    }

    private static void moveToRow(int i, StringBuilder output) {
        if (isInBounds(row + i)) {
            row += i;
            if (Character.isLetter(matrix[row][col])) {
                output.append(matrix[row][col]);
            }
        } else {
            outOfBounds(output, previousPos);
        }
    }

    private static void outOfBounds(StringBuilder output, char previousPos) {
        if (Character.isLetter(previousPos)) {
            if (0 < output.length()) {
                int index = output.length() - 1;
                output.deleteCharAt(index);
            }
        }
    }

    private static boolean isInBounds(int index) {
        return 0 <= index && index < matrix.length;
    }

    private static int[] getInitialPosition(char[][] matrix) {
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

    private static void printMatrix() {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }
    }
}
