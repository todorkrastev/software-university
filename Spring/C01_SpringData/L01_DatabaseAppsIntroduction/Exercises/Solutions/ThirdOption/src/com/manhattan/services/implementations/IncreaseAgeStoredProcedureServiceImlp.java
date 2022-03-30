package com.manhattan.services.implementations;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import static com.manhattan.common.Utilities.printRedMessage;
import static com.manhattan.common.Utilities.readIntFromConsole;

/**
 * 9. Increase Age Stored Procedure
 *
 * @apiNote You have to run SQL script to create stored procedure before run code!!!
 * -- The query for creation ot the stored procedure for problem 9 Increase Age Stored Procedure
 * DROP procedure IF EXISTS `minions_db`.`usp_get_older`;
 *
 * DELIMITER $$
 * USE `minions_db`$$
 * CREATE PROCEDURE `usp_get_older`(minion_id INT)
 * BEGIN
 * UPDATE minions SET age = age + 1 WHERE id = minion_id;
 * END$$
 *
 * DELIMITER ;
 * ;
 */
public class IncreaseAgeStoredProcedureServiceImlp extends BaseServiceImpl {

    public IncreaseAgeStoredProcedureServiceImlp(Connection connection) {
        super(connection);
    }

    @Override
    public void execute() throws SQLException, IOException {
        int minionId = readIntFromConsole("Enter minion id: ");
        CallableStatement statement = connection.prepareCall("CALL usp_get_older(?)");
        statement.setInt(1, minionId);
        int affectedRecords = statement.executeUpdate();
        printRecordsAffectedMessage(affectedRecords);
    }

    private void printRecordsAffectedMessage(int affectedRecords) {
        String messageTemplate = affectedRecords > 1 ? "%d records affected%n" : "%d record affected%n";
        System.out.printf(messageTemplate, affectedRecords);
    }

}

