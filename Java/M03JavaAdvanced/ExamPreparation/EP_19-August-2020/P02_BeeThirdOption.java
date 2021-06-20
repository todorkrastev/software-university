import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P02_BeeThirdOption {

    private static char[][] matrix;
    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfMatrix][];
        readMatrix(reader);
        int[] startingPoint = getStartingPoint();
        row = startingPoint[0];
        col = startingPoint[1];

        int pollinatedFlowersCounter = 0;
        int lastIndex = 0;
        String rowOrCol = "";
        String command;
        while (isInBounds() && !"End".equals(command = reader.readLine())) {
            matrix[row][col] = '.';
            switch (command) {
                case "up":
                    lastIndex = -1;
                    rowOrCol = "row";
                    row--;
                    break;
                case "down":
                    lastIndex = +1;
                    rowOrCol = "row";
                    row++;
                    break;
                case "left":
                    lastIndex = -1;
                    rowOrCol = "col";
                    col--;
                    break;
                case "right":
                    lastIndex = +1;
                    rowOrCol = "col";
                    col++;
                    break;
                default:
                    break;
            }
            if (isInBounds()) {
                if (matrix[row][col] == 'f') {
                    pollinatedFlowersCounter++;
                } else if (matrix[row][col] == 'O') {
                    if (rowOrCol.equals("row")) {
                        matrix[row][col] = '.';
                        pollinatedFlowersCounter += moveToRow(lastIndex);
                    } else if (rowOrCol.equals("col")) {
                        matrix[row][col] = '.';
                        pollinatedFlowersCounter += moveToCol(lastIndex);
                    }
                }
            }
        }
        if (!isInBounds()) {
            System.out.println("The bee got lost!");
        } else {
            matrix[row][col] = 'B';
        }
        if (5 <= pollinatedFlowersCounter) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowersCounter);
        } else {
            int diff = 5 - pollinatedFlowersCounter;
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", diff);
        }

        printMatrix();
    }

    private static int moveToCol(int lastIndex) {
        int counter = 0;
        col += lastIndex;
        if (isInBounds()) {
            if (matrix[row][col] == 'f') {
                counter++;
            }
        }
        return counter;
    }

    private static int moveToRow(int lastIndex) {
        int counter = 0;
        row += lastIndex;
        if (isInBounds()) {
            if (matrix[row][col] == 'f') {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isInBounds() {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static int[] getStartingPoint() {
        int[] startingPoint = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    startingPoint[0] = row;
                    startingPoint[1] = col;
                }
            }
        }
        return startingPoint;
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
