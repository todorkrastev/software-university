package bg.softuni.java_advanced.exam_preparation_23_October_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class P01_TheGardenSecondOption {

    private static char[][] matrix;
    private static Map<String, Integer> vegetables;
    private static int countHarmed = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        readMatrix(reader, Integer.parseInt(reader.readLine()));
        vegetables = new LinkedHashMap<>() {{
            put("Carrots", 0);
            put("Potatoes", 0);
            put("Lettuce", 0);
        }};
        String input;
        int row, col;

        while (!"End of Harvest".equals(input = reader.readLine())) {
            String[] command = input.split("\\s+");
            row = Integer.parseInt(command[1]);
            col = Integer.parseInt(command[2]);

            if (command[0].equals("Harvest")) {
                checkVegetable(row, col);
            } else {
                if (isValidIndexes(row, col)) {
                    if ("up".equals(command[3])) {
                        moveToNext(row, col, -2, "rows");
                    } else if ("down".equals(command[3])) {
                        moveToNext(row, col, 2, "rows");
                    } else if ("left".equals(command[3])) {
                        moveToNext(row, col, -2, "cols");
                    } else if ("right".equals(command[3])) {
                        moveToNext(row, col, 2, "cols");
                    }
                }
            }
        }
        printMatrix();
        vegetables.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        System.out.println("Harmed vegetables: " + countHarmed);

    }

    private static void moveToNext(int row, int col, int index, String direction) {
        while (isValidIndexes(row, col)) {
            checkCell(row, col);
            if (direction.equals("rows")) {
                row = Math.abs(row) + index;
            } else {
                col = Math.abs(col) + index;
            }
        }
    }

    private static void checkCell(int row, int col) {
        if (matrix[row][col] != ' ') {
            countHarmed++;
            matrix[row][col] = ' ';
        }
    }

    private static void checkVegetable(int row, int col) {
        if (isValidIndexes(row, col)) {
            char current = matrix[row][col];
            if (current == 'L') {
                vegetables.put("Lettuce", vegetables.get("Lettuce") + 1);
            } else if (current == 'P') {
                vegetables.put("Potatoes", vegetables.get("Potatoes") + 1);
            } else if (current == 'C') {
                vegetables.put("Carrots", vegetables.get("Carrots") + 1);
            }
            matrix[row][col] = ' ';
        }
    }

    private static boolean isValidIndexes(int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static void readMatrix(BufferedReader reader, int n) throws IOException {
        matrix = new char[n][];
        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static void printMatrix() {
        Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)
                .replaceAll("[\\[\\]]", "").replaceAll(", ", " ")));
    }
}

