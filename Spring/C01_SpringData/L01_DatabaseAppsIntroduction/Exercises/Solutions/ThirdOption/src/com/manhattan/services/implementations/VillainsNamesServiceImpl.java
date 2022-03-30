package com.manhattan.services.implementations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Problem 2. Get Villains’ Names
 */
public class VillainsNamesServiceImpl extends BaseServiceImpl {

    public VillainsNamesServiceImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT v.`name`, COUNT(DISTINCT mv.minion_id) AS minions_count " +
                            "FROM villains as v " +
                            "         JOIN minions_villains as mv on v.id = mv.villain_id " +
                            "GROUP BY mv.villain_id " +
                            "HAVING minions_count > 15 " +
                            "ORDER BY minions_count DESC;");
            while (resultSet.next()) {
                printVillainsWithMinionsCount(resultSet);
            }
        }
    }

    private void printVillainsWithMinionsCount(ResultSet resultSet) throws SQLException {
        String villainName = resultSet.getString(1);
        int minionsCount = resultSet.getInt(2);
        System.out.printf("%s %d%n", villainName, minionsCount);
    }
}
