package com.manhattan.utils;

import java.io.IOException;

public interface ConsoleService {
    int readIntFromConsole(String message) throws IOException;

    String readStringFromConsole(String message) throws IOException;

    void printMessage(String message);

    void printResultMessage(String message);

    void printInfoMessage(String message);

    void printRedMessage(String message);

    void holdUntilKeyPressed() throws IOException;
}
