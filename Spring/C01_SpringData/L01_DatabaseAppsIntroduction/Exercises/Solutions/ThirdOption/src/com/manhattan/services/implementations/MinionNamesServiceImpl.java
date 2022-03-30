package com.manhattan.services.implementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.manhattan.common.Utilities.readIntFromConsole;

/**
 * Problem 3. Get Minion Names
 */
public class MinionNamesServiceImpl extends BaseServiceImpl {
    public MinionNamesServiceImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException, IOException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT v.name, m.name, m.age " +
                "FROM villains AS v " +
                "    JOIN minions_villains AS mv ON mv.villain_id = v.id " +
                "    JOIN minions m ON m.id = mv.minion_id " +
                "WHERE v.id = ?")) {

            int villainId = readIntFromConsole("Enter villain id: ");
            statement.setInt(1, villainId);
            ResultSet resultSet = statement.executeQuery();
            printMinionData(resultSet, villainId);


            if (resultSet.isBeforeFirst()) {
                System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            }
        }
    }

    private void printMinionData(ResultSet resultSet, int villainId) throws SQLException {
        if (resultSet.next() == false) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
        } else {
            String villainName = resultSet.getString(1);
            System.out.printf("Villain: %s%n", villainName);
            int counter = 1;
            do {
                String minionName = resultSet.getString(2);
                int minionAge = resultSet.getInt(3);
                System.out.printf("%d. %s %d%n", counter++, minionName, minionAge);
            } while (resultSet.next());
        }
    }
}
