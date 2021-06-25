import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P02_TheGardenThirdOption {

    private static char[][] matrix;
    private static int row;
    private static int col;
    private static int harmedVegetablesCounter = 0;
    private static int carrotCounter = 0;
    private static int potatoCounter = 0;
    private static int lettuceCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int rowsOfMatrix = Integer.parseInt(reader.readLine());
        matrix = new char[rowsOfMatrix][];
        readMatrix(reader);

        String input;
        while (!"End of Harvest".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split("\\s+");
            String command = tokens[0];
            row = Integer.parseInt(tokens[1]);
            col = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Harvest":
                    counterVegetables();
                    break;
                case "Mole":
                    String dir = tokens[3];
                    switch (dir) {
                        case "up":
                            moveTo("row", -2);
                            break;
                        case "down":
                            moveTo("row", 2);
                            break;
                        case "left":
                            moveTo("col", -2);
                            break;
                        case "right":
                            moveTo("col", 2);
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
        System.out.printf("Carrots: %d%n", carrotCounter);
        System.out.printf("Potatoes: %d%n", potatoCounter);
        System.out.printf("Lettuce: %d%n", lettuceCounter);
        System.out.printf("Harmed vegetables: %d%n", harmedVegetablesCounter);
    }

    private static void moveTo(String rowOrCol, int index) {
        while (isInBounds()) {
            checkCell();
            if (rowOrCol.equals("row")) {
                row += index;
            } else {
                col += index;
            }
        }
    }

    private static void checkCell() {
        if (matrix[row][col] != ' ') {
            harmedVegetablesCounter++;
            matrix[row][col] = ' ';
        }
    }

    private static void counterVegetables() {
        if (isInBounds() && matrix[row][col] != ' ') {
            switch (matrix[row][col]) {
                case 'C':
                    carrotCounter++;
                    break;
                case 'P':
                    potatoCounter++;
                    break;
                case 'L':
                    lettuceCounter++;
                    break;
                default:
                    break;
            }
            matrix[row][col] = ' ';
        }
    }

    private static boolean isInBounds() {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
    }

    private static void printMatrix() {
        Arrays
                .stream(matrix)
                .forEach(e -> System.out.println(Arrays.toString(e)
                        .replaceAll("[\\[\\]]", "")
                        .replaceAll(", ", " ")));
    }
}
