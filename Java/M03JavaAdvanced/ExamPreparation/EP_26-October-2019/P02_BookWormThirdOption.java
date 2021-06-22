import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P02_BookWormThirdOption {

    private static char[][] matrix;
    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String initialStr = reader.readLine();
        StringBuilder output = new StringBuilder();
        output.append(initialStr);
        int sizeOfMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfMatrix][];
        int[] startingPoint = readMatrix(reader);
        row = startingPoint[0];
        col = startingPoint[1];

        int[] previousPosition;
        String command;
        while (!"end".equals(command = reader.readLine())) {
            previousPosition = getCurrPos();
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
            if (isInBounds()) {
                if (Character.isLetter(matrix[row][col])) {
                    output.append(matrix[row][col]);
                }
            } else {
                output.deleteCharAt(output.length() - 1);
                row = previousPosition[0];
                col = previousPosition[1];
            }
            matrix[row][col] = 'P';
        }
        System.out.println(output);
        printMatrix();
    }

    private static int[] getCurrPos() {
        int[] previousPosition = new int[2];
        previousPosition[0] = row;
        previousPosition[1] = col;
        return previousPosition;
    }

    private static boolean isInBounds() {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static void printMatrix() {
        Arrays.stream(matrix)
                .map(row -> Arrays.toString(row)
                        .replaceAll("[\\[\\], ]", ""))
                .forEach(System.out::println);
    }

    private static int[] readMatrix(BufferedReader reader) throws IOException {
        int[] rowAndCol = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            String line = reader.readLine();
            matrix[row] = line.toCharArray();
            if (line.contains("P")) {
                rowAndCol[0] = row;
                rowAndCol[1] = line.indexOf('P');
            }
        }
        return rowAndCol;
    }
}
