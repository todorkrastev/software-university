package com.manhattan.services.implementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.manhattan.common.Utilities.readStringFromConsole;

/**
 * 5. Change Town Names Casing
 */
public class ChangeTownNamesCasingServiceImlp extends BaseServiceImpl {

    public ChangeTownNamesCasingServiceImlp(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException, IOException {
        String countryName = readStringFromConsole("Enter country name: ");
        int affectedTownsCount = updateTowns(countryName);
        if (affectedTownsCount > 0) {
            System.out.printf("%d town names were affected.%n", affectedTownsCount);
            List<String> affectedTownsNames = getAffectedTownNames(countryName);
            System.out.println(affectedTownsNames);
        } else {
            System.out.println("No town names were affected.");
        }
    }

    private int updateTowns(String countryName) throws SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?");
        statement.setString(1, countryName);
        return statement.executeUpdate();
    }

    private List<String> getAffectedTownNames(String countryName) throws SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("SELECT name FROM towns WHERE country = ?");
        statement.setString(1, countryName);
        List<String> townsNames = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            townsNames.add(resultSet.getString(1));
        }
        return townsNames;
    }
}
