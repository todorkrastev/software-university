package com.manhattan.utils;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class ConsoleServiceImpl implements ConsoleService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private final BufferedReader reader;

    public ConsoleServiceImpl(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public int readIntFromConsole(String message) throws IOException {
        return Integer.parseInt(readStringFromConsole(message));
    }

    @Override
    public String readStringFromConsole(String message) throws IOException {
        System.out.print(message);
        return reader.readLine();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printResultMessage(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    @Override
    public void printInfoMessage(String message) {
        System.out.println(ANSI_CYAN + message + ANSI_RESET);
    }

    @Override
    public void printRedMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    @Override
    public void holdUntilKeyPressed() throws IOException {
        printRedMessage("Press Enter to continue...");
        reader.readLine();
    }
}
