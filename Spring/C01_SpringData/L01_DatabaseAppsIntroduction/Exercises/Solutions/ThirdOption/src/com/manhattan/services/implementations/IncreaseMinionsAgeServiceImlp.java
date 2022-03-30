package com.manhattan.services.implementations;

import com.manhattan.services.interfaces.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printRedMessage;
import static com.manhattan.common.Utilities.readStringFromConsole;

/**
 * 8. Increase Minions Age
 */
public class IncreaseMinionsAgeServiceImlp extends BaseServiceImpl {

    public IncreaseMinionsAgeServiceImlp(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException, IOException {
        PreparedStatement statement = null;
        try {
            String ids = consoleReadIds();
            // There is no possibilities for SQL injection because the result is prepared to get only stringified array of integers
            String query = String.format("UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id IN(%s)", ids);
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            statement.close();

            statement = connection.prepareStatement("SELECT name, age FROM minions");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%s %d%n",
                        resultSet.getString(1),
                        resultSet.getInt(2));
            }
        } catch (NumberFormatException pe) {
            printRedMessage("Invalid input");
            printRedMessage("pe.getMessage()");
        } finally {
            if (statement != null){
                statement.close();
            }
        }
    }

    private String consoleReadIds() throws IOException {
        return Arrays.stream(readStringFromConsole("Enter minions IDs separated by space: ")
                        .split("\\s+"))
                .map(Integer::parseInt)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
