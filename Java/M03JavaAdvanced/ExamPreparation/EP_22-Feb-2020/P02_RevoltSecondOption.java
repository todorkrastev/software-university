import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P02_RevoltSecondOption {
    private static char[][] matrix;
    private static int row;
    private static int col;
    private static int index;
    private static String rowOrCol;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfMatrix = Integer.parseInt(reader.readLine());
        int numOfCommands = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfMatrix][];
        readMatrix(reader);
        int[] startingPoint = getStartingPoint();
        row = startingPoint[0];
        col = startingPoint[1];

        while (0 < numOfCommands-- && matrix[row][col] != 'F') {
            matrix[row][col] = '-';
            String command = reader.readLine();
            checkPosition(command);
            if (isInBounds()) {
                checkLetter();
                if (!isInBounds()) {
                    moveToRowOrCol();
                }
            } else {
                moveToRowOrCol();
            }
        }
        System.out.println(matrix[row][col] == 'F' ? "Player won!" : "Player lost!");
        matrix[row][col] = 'f';
        printMatrix();
    }

    private static void checkPosition(String command) {
        switch (command) {
            case "up":
                row--;
                index = -1;
                rowOrCol = "row";
                break;
            case "down":
                row++;
                index = 1;
                rowOrCol = "row";
                break;
            case "left":
                col--;
                index = -1;
                rowOrCol = "col";
                break;
            case "right":
                col++;
                index = 1;
                rowOrCol = "col";
                break;
            default:
                break;
        }
    }

    private static void moveToRowOrCol() {
        if (rowOrCol.equals("row")) {
            if (index == 1) {
                row = 0;
            } else if (index == -1) {
                row = matrix.length - 1;
            }
            checkLetter();
        } else if (rowOrCol.equals("col")) {
            if (index == 1) {
                col = 0;
            } else if (index == -1) {
                col = matrix[row].length - 1;
            }
            checkLetter();
        }
    }

    private static void checkLetter() {
        if (isItTrapOrBonus('B')) {
            moveTo();
        } else if (isItTrapOrBonus('T')) {
            moveBackTo();
        }
    }

    private static void moveBackTo() {
        if (rowOrCol.equals("row")) {
            row -= index;
        } else {
            col -= index;
        }
    }

    private static void moveTo() {
        if (rowOrCol.equals("row")) {
            row += index;
        } else {
            col += index;
        }
    }

    private static boolean isItTrapOrBonus(char letterToFind) {
        return matrix[row][col] == letterToFind;
    }

    private static boolean isInBounds() {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static int[] getStartingPoint() {
        int[] startingPoint = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f') {
                    startingPoint[0] = row;
                    startingPoint[1] = col;
                }
            }
        }
        return startingPoint;
    }

    private static void printMatrix() {
        Arrays.stream(matrix)
                .map(row -> Arrays.toString(row)
                        .replaceAll("[\\[\\]]", "")
                        .replaceAll(", ", ""))
                .forEach(System.out::println);
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }
    }
}
