import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P02_BookWormFourthOption {

    private static char[][] matrix;
    private static int wormRow;
    private static int wormCol;
    private static final int[] previousPosition = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        final String initialStr = reader.readLine();
        StringBuilder output = new StringBuilder();
        output.append(initialStr);
        final int sizeOfSquareMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[sizeOfSquareMatrix][];
        readMatrix(reader);

        String command;
        while (!"end".equals(command = reader.readLine())) {
            previousPosition[0] = wormRow;
            previousPosition[1] = wormCol;
            matrix[wormRow][wormCol] = '-';

            switch (command) {
                //Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]
                case "up":
                    wormRow--;
                    break;
                case "down":
                    wormRow++;
                    break;
                case "left":
                    wormCol--;
                    break;
                case "right":
                    wormCol++;
                    break;
                default:
                    break;
            }
            if (isInBounds()) {
                concatenateLetter(output);
            } else if (!isInBounds()) {
                removeLastLetter(output);
                wormRow = previousPosition[0];
                wormCol = previousPosition[1];
            }
            matrix[wormRow][wormCol] = 'P';
        }
        System.out.println(output);
        printMatrix();
    }

    private static void removeLastLetter(StringBuilder output) {
        if (output != null) {
            output.deleteCharAt(output.length() - 1);
        }
    }

    private static void concatenateLetter(StringBuilder output) {
        if (Character.isLetter(matrix[wormRow][wormCol])) {
            char letter = matrix[wormRow][wormCol];
            output.append(letter);
        }
    }

    private static boolean isInBounds() {
        return 0 <= wormRow && wormRow < matrix.length && 0 <= wormCol && wormCol < matrix[wormRow].length;
    }

    private static void printMatrix() {
        Arrays
                .stream(matrix)
                .map(row -> Arrays.toString(row)
                        .replaceAll("[\\[\\]]", "")
                        .replaceAll(", ", ""))
                .forEach(System.out::println);
    }

    private static void readMatrix(BufferedReader reader) {
      /*  for (int row = 0; row < matrix.length; row++) {
            String input = reader.readLine();
            matrix[row] = input
                    .replaceAll("[\\[\\]]", "")
                    .replaceAll(", ", "")
                    .toCharArray();
            if (input.contains("P")) {
                beeRow = row;
                beeCol = input.indexOf('P');
            }
        }
   */
        IntStream.range(0, matrix.length).forEach(row -> {
            String input = null;
            try {
                input = reader.readLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            assert input != null;
            if (input.contains("P")) {
                wormRow = row;
                wormCol = input.indexOf('P');
            }
            matrix[row] = input.toCharArray();
        });
    }
}
