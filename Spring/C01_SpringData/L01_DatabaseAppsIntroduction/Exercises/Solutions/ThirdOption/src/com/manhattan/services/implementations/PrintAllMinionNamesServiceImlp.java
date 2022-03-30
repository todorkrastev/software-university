package com.manhattan.services.implementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;

import static com.manhattan.common.Utilities.printRedMessage;

/**
 * 7. Print All Minion Names
 * @apiNote You have to reload fresh database to get the answer as in problem!!!
 */
public class PrintAllMinionNamesServiceImlp extends BaseServiceImpl {

    public PrintAllMinionNamesServiceImlp(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException, IOException {
        PreparedStatement statement = connection
                .prepareStatement("SELECT name FROM minions");
        ArrayDeque<String> minionsNames = new ArrayDeque<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            minionsNames.add(resultSet.getString(1));
        }

        int counter = 0;
        while (!minionsNames.isEmpty()) {
            System.out.println(counter++ % 2 == 0 ? minionsNames.pollFirst() : minionsNames.pollLast());
        }
    }
}
