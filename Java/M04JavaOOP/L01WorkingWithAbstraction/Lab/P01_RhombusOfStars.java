package bg.softuni.java_oop.working_with_abstraction.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class P01_RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int size = Integer.parseInt(reader.readLine());
        printRhombus(size);
    }

    private static void printRhombus(int size) {
        printTriangle(size, true);
        printTriangle(size, false);
    }

    private static void printTriangle(int n, boolean directionUp) {
        for (int i = 1; i <= n; i++) {
            int firstSymbolCount = directionUp ? n - i : i;
            int secondSymbolCount = directionUp ? i : n - i;
            printRow(firstSymbolCount, " ");
            printRow(secondSymbolCount, "* ");
            System.out.println();
        }
    }

    private static void printRow(int count, String symbol) {
        for (int j = 1; j <= count; j++) {
            System.out.print(symbol);
        }
    }
}