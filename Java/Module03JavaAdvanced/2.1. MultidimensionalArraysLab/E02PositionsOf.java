package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E02PositionsOf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] rowsAndCols = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] intMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int num = Integer.parseInt(reader.readLine());

        List<int[]> indexes = new LinkedList<>();

        findTheNum(intMatrix, indexes, num);

        if (indexes.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] index : indexes) {
                System.out.println(index[0] + " " + index[1]);
            }
        }
    }

    private static void findTheNum(int[][] intMatrix, List<int[]> indexes, int num) {
        for (int row = 0; row < intMatrix.length; row++) {
            for (int col = 0; col < intMatrix[row].length; col++) {
                if (intMatrix[row][col] == num) {
                    indexes.add(new int[] {row, col});
                }
            }
        }
    }
}