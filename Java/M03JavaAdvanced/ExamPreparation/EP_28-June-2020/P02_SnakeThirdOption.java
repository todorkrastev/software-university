import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P02_SnakeThirdOption {

    private static char[][] matrix;
    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int sizeOfMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfMatrix][];
        readMatrix(reader);
        int[] startingPosition = getStartingPosition('S');
        row = startingPosition[0];
        col = startingPosition[1];

        int foodCounter = 0;
        String command;
        while (foodCounter < 10 && isInBounds()) {
            matrix[row][col] = '.';
            command = reader.readLine();
            switch (command) {
                //Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]

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
                if (matrix[row][col] == '*') {
                    foodCounter++;
                } else if (matrix[row][col] == 'B') {
                    matrix[row][col] = '.';
                    startingPosition = getStartingPosition('B');
                    row = startingPosition[0];
                    col = startingPosition[1];
                }
            }
        }
        if (isInBounds()) {
            matrix[row][col] = 'S';
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + foodCounter);

        printMatrix();
    }

    private static boolean isInBounds() {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static int[] getStartingPosition(char findLetter) {
        int[] startingPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == findLetter) {
                    startingPosition[0] = row;
                    startingPosition[1] = col;
                }
            }
        }
        return startingPosition;
    }

    private static void printMatrix() {
        Arrays
                .stream(matrix)
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
