package bg.softuni.java_advanced.multidimensional_arrays.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int[] rowsAndCols = Arrays.stream(reader.readLine().trim().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] intMatrix = readMatrix(reader, rows, cols);

        List<int[]> list = new LinkedList<>();

        int maxSum = getMaxSum(intMatrix, list);

        list
                .forEach(e -> System.out.println(e[0] + " " + e[1]));
        System.out.println(maxSum);
    }

    private static int getMaxSum(int[][] intMatrix, List<int[]> list) {
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < intMatrix.length - 1; row++) {
            for (int col = 0; col < intMatrix[row].length - 1; col++) {
                int currSum = intMatrix[row][col] + intMatrix[row][col + 1] + intMatrix[row + 1][col] + intMatrix[row + 1][col + 1];
                if (maxSum < currSum) {
                    list.clear();
                    list.add(new int[]{intMatrix[row][col], intMatrix[row][col + 1]});
                    list.add(new int[]{intMatrix[row + 1][col], intMatrix[row + 1][col + 1]});
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }
    
    private static int[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        int[][] intMatrix = new int[rows][cols];

        for (int row = 0; row < intMatrix.length; row++) {
            intMatrix[row] = Arrays.stream(reader.readLine().trim().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return intMatrix;
    }
}