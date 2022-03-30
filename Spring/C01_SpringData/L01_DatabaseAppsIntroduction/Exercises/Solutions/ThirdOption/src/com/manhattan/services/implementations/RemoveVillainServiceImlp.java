package com.manhattan.services.implementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.manhattan.common.Utilities.findEntityNameById;
import static com.manhattan.common.Utilities.readIntFromConsole;

/**
 * 6. Remove Villain
 */
public class RemoveVillainServiceImlp extends BaseServiceImpl {

    public RemoveVillainServiceImlp(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException, IOException {
        int id = readIntFromConsole("Enter villain id: ");
        String villainName = findEntityNameById("villains", id, this.connection);
        if (villainName != null) {
            int releasedMinionsCount = releaseVillainsMinions(id);
            if (deleteVillain(id)) {
                System.out.printf("%s was deleted%n", villainName);
                System.out.printf("%d minions released%n", releasedMinionsCount);
            }
        } else {
            System.out.println("No such villain was found");
        }
    }

    private int releaseVillainsMinions(int id) throws SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        statement.setInt(1, id);
        return statement.executeUpdate();
    }

    private boolean deleteVillain(int id) throws SQLException {
        PreparedStatement statement = this.connection
                .prepareStatement("DELETE FROM villains WHERE id = ?");
        statement.setInt(1, id);
        return statement.executeUpdate() > 0;
    }
}
