package com.manhattan.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.manhattan.common.CommonConstants.ANSI_RED;
import static com.manhattan.common.CommonConstants.ANSI_RESET;

public class Utilities {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readStringFromConsole(String message) throws IOException {
        System.out.print(message);
        return reader.readLine();
    }

    public static int readIntFromConsole(String message) throws IOException {
        return Integer.parseInt(readStringFromConsole(message));
    }

    public static void printRedMessage(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public static String findEntityNameById(String entityName, int id, Connection connection) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", entityName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        String name = null;
        if (resultSet.next()) {
            name = resultSet.getString(1);
        }

        return name;
    }

    public static int findEntityIdByName(String entityName, String name, Connection connection) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", entityName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        int resultId = 0;
        if (resultSet.next()) {
            resultId = resultSet.getInt(1);
        }

        return resultId;
    }

    public static void holdUntilKeyPressed() throws IOException {
        printRedMessage("Press Enter to continue...");
        reader.readLine();
    }
}
