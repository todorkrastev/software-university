package com.manhattan.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readStringFromConsole(String message) throws IOException {
        System.out.print(message);
        return reader.readLine();
    }

    public static int readIntFromConsole(String message) throws IOException {
        return Integer.parseInt(readStringFromConsole(message));
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printResultMessage(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void printInfoMessage(String message) {
        System.out.println(ANSI_CYAN + message + ANSI_RESET);
    }

    public static void printRedMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public static void holdUntilKeyPressed() throws IOException {
        printRedMessage("Press Enter to continue...");
        reader.readLine();
    }
}
