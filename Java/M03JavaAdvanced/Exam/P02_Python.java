import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_Python {

    private static int pythonLength = 1;
    private static char[][] matrix;
    private static int row;
    private static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfSquareMatrix = Integer.parseInt(scanner.nextLine());
        matrix = new char[sizeOfSquareMatrix][];
        ArrayDeque<String> directionsQueue = Arrays.stream(scanner.nextLine().trim().split(", "))
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));

                readMatrix(scanner);

        while (!directionsQueue.isEmpty() && !isLetterE()) {
            switch (directionsQueue.poll()) {
                //Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]
                case "up":
                    row--;
                    if (row < 0) {
                        row = matrix.length - 1;
                    }
                    break;
                case "down":
                    row++;
                    if (matrix.length - 1 < row) {
                        row = 0;
                    }
                    break;
                case "left":
                    col--;
                    if (col < 0) {
                        col = matrix[row].length - 1;
                    }
                    break;
                case "right":
                    col++;
                    if (matrix[row].length - 1 < col) {
                        col = 0;
                    }
                    break;
                default:
                    break;
            }
            if (matrix[row][col] == 'f') {
                matrix[row][col] = '*';
                pythonLength++;
            }
        }
        if (eatenFood() == 0) {
            System.out.printf("You win! Final python length is %d%n", pythonLength);
        } else if (isLetterE()) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", eatenFood());
        }
    }

    private static int eatenFood() {
        int count = 0;
        for (char[] chars : matrix) {
            for (int c = 0; c < matrix[row].length; c++) {
                if (chars[c] == 'f') {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isLetterE() {
        return matrix[row][col] == 'e';
    }

    private static void readMatrix(Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine().replaceAll("\\s+", "").trim();
            matrix[r] = input.toCharArray();
            if (input.contains("s")) {
                row = r;
                col = input.indexOf('s');
            }
        }
    }
}