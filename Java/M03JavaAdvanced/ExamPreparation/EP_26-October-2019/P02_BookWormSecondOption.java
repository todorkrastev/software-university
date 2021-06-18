package bg.softuni.java_advanced.exam_preparation_26_October_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P02_BookWormSecondOption {
    private static char[][] field;
    private static int playerRol;
    private static int playerCol;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        StringBuilder input = new StringBuilder(reader.readLine());
        readField(reader, Integer.parseInt(reader.readLine()));
        String command;

        while (!"end".equals(command = reader.readLine())) {
            setPosition('-');
            if ("up".equals(command)) {
                moveToRow(-1, input);
            } else if ("down".equals(command)) {
                moveToRow(1, input);
            } else if ("right".equals(command)) {
                moveToCol(1, input);
            } else if ("left".equals(command)) {
                moveToCol(-1, input);
            }
            setPosition('P');
        }
        System.out.println(input);
        printField();
    }

    private static void moveToRow(int n, StringBuilder input) {
        if (isInBounds(playerRol + n)) {
            playerRol += n;
            chekPosition(input);
        } else {
            cutString(input);
        }
    }

    private static void moveToCol(int n, StringBuilder input) {
        if (isInBounds(playerCol + n)) {
            playerCol += n;
            chekPosition(input);
        } else {
            cutString(input);
        }
    }

    private static void setPosition(char c) {
        field[playerRol][playerCol] = c;
    }

    private static void cutString(StringBuilder input) {
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        }
    }

    private static void chekPosition(StringBuilder input) {
        if (field[playerRol][playerCol] != '-') {
            input.append(field[playerRol][playerCol]);
        }
    }

    private static boolean isInBounds(int index) {
        return index < field.length && index >= 0;
    }

    private static void printField() {
        Arrays.stream(field).map(row -> Arrays.toString(row)
                .replaceAll("[\\[\\], ]", "")).forEach(System.out::println);
    }

    private static void readField(BufferedReader reader, int n) {
        field = new char[n][n];
        IntStream.range(0, n).forEach(i -> {
            String input = "";
            try {
                input = reader.readLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if (input.contains("P")) {
                playerRol = i;
                playerCol = input.indexOf('P');
            }
            field[i] = input.toCharArray();
        });
    }
}
