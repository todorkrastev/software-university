package com.manhattan.services.implementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import static com.manhattan.common.Utilities.findEntityIdByName;
import static com.manhattan.common.Utilities.readStringFromConsole;

/**
 * problem 4. Add Minion
 */
public class AddMinionsServiceImpl extends BaseServiceImpl {
    public AddMinionsServiceImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException, IOException {
        String minionName = "";
        int minionAge = 0;
        String town = "";
        String villainName = "";
        for (int i = 0; i < 2; i++) {
            String[] tokens = readStringFromConsole("").split("\\s+");
            if (tokens[0].equals("Minion:")) {
                minionName = tokens[1];
                minionAge = Integer.parseInt(tokens[2]);
                town = tokens[3];
            } else {
                villainName = tokens[1];
            }
        }
        int townId = insertTownIfNotExist(town);
        int minionId = insertMinionIfNotExist(minionName, minionAge, townId);
        int villainId = insertVillainIfNotExist(villainName);
        if (insertMinionToVillain(minionId, villainId)) {
            System.out.printf("Successfully added %s to be minion of %s%n", minionName, villainName);
        }
    }

    private boolean insertMinionToVillain(int minionId, int villainId) throws SQLException {
        try (PreparedStatement insertStatement = this.connection
                .prepareStatement("INSERT INTO minions_villains(minion_id, villain_id) VALUES (?,?)")) {
            insertStatement.setInt(1, minionId);
            insertStatement.setInt(2, villainId);
            int insertedRecordsCount = insertStatement.executeUpdate();
            return insertedRecordsCount > 0;
        }
    }

    private int insertVillainIfNotExist(String villainName) throws SQLException {
        int villainId = findEntityIdByName("villains", villainName, connection);
        if (villainId == 0) {
            try (PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO villains(`name`) VALUES (?)")) {
                statement.setString(1, villainName);
                int insertedRecordsCount = statement.executeUpdate();
                if (insertedRecordsCount > 0) {
                    villainId = findEntityIdByName("villains", villainName, this.connection);
                    System.out.printf("Villain %s was added to the database.%n", villainName);
                }
            }
        }

        return villainId;
    }

    private int insertMinionIfNotExist(String minionName, int minionAge, int townId) throws SQLException {
        int minionId = findEntityIdByName("minions", minionName, this.connection);
        if (minionId == 0) {
            try (PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO minions(`name`, age, town_id) VALUES (?,?,?)")) {
                statement.setString(1, minionName);
                statement.setInt(2, minionAge);
                statement.setInt(3, townId);
                int insertedRecordsCount = statement.executeUpdate();
                if (insertedRecordsCount > 0) {
                    minionId = findEntityIdByName("minions", minionName, this.connection);
                }
            }
        }

        return minionId;
    }

    private int insertTownIfNotExist(String townName) throws SQLException {
        int townId = findEntityIdByName("towns", townName, this.connection);
        if (townId == 0) {
            try (PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO towns(`name`) VALUES (?)")) {
                statement.setString(1, townName);
                int insertedRecordsCount = statement.executeUpdate();
                if (insertedRecordsCount > 0) {
                    townId = findEntityIdByName("towns", townName, this.connection);
                    System.out.printf("Town %s was added to the database.%n", townName);
                }
            }
        }

        return townId;
    }
}
