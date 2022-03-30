package com.manhattan.consoleApp;

import com.manhattan.common.exceptions.ProblemNotFoundException;
import com.manhattan.services.interfaces.Service;
import com.manhattan.services.interfaces.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;

import static com.manhattan.common.Utilities.*;

public class Application {
    private final ServiceFactory factory;

    public Application(ServiceFactory factory) throws SQLException, IOException {
        this.factory = factory;
    }

    public void run() throws IOException, SQLException {
        printMainMenu();
        int problemNumber = readIntFromConsole("Choose the problem number: ");
        checkForSpacialCases(problemNumber);
        try {
            Service service = this.factory.getService(problemNumber);
            service.execute();
        } catch (ProblemNotFoundException e) {
            e.getMessage();
        }
    }

    private void printMainMenu() {
        System.out.println("2. Get Villain's Names");
        System.out.println("3. Get Minion Names");
        System.out.println("4. Add Minion");
        System.out.println("5. Change Town Names Casing");
        System.out.println("6. Remove Villain");
        System.out.println("7. Print All Minion Names");
        System.out.println("8. Increase Minions Age");
        System.out.println("9. Increase Age Stored Procedure");
    }

    private void checkForSpacialCases(int problemNumber) throws IOException {

        switch (problemNumber) {
            case 7:
                printRedMessage("You have to reload fresh database to get the answer as in problem!!!");
                holdUntilKeyPressed();
                break;
            case 9:
                printRedMessage("You have to run SQL script to create stored procedure before run code!!!");
                holdUntilKeyPressed();
                break;
        }

    }
}
