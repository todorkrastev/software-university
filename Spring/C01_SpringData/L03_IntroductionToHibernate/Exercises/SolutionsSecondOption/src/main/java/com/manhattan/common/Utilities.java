package com.manhattan.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.manhattan.common.CommonConstants.*;

public class Utilities {
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
    public static void printRedMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public static void holdUntilKeyPressed() throws IOException {
        printRedMessage("Press Enter to continue...");
        reader.readLine();
    }
}
