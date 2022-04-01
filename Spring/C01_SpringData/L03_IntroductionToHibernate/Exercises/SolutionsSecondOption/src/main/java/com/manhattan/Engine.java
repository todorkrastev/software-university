package com.manhattan;

import com.manhattan.common.exceptions.ProblemNotFoundException;
import com.manhattan.services.interfaces.Service;
import com.manhattan.services.interfaces.ServiceFactory;

import java.io.IOException;

import static com.manhattan.common.Utilities.*;

public class Engine implements Runnable {
    private final ServiceFactory factory;

    public Engine(ServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        printMessage(getMainMenu());
        int problemNumber = 0;
        try {
            problemNumber = readIntFromConsole("Choose the problem number: ");
            Service service = this.factory.getService(problemNumber);
            service.execute();
        } catch (ProblemNotFoundException e) {
            printRedMessage(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getMainMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Problems list").append(System.lineSeparator());
        stringBuilder.append("-------------").append(System.lineSeparator()).append(System.lineSeparator());
        stringBuilder.append("2.Change casing").append(System.lineSeparator());
        stringBuilder.append("3.Contains Employee").append(System.lineSeparator());
        stringBuilder.append("4.Employees with Salary Over 50 000").append(System.lineSeparator());
        stringBuilder.append("5.Employees from Department").append(System.lineSeparator());
        stringBuilder.append("6.Adding a New Address and Updating Employee").append(System.lineSeparator());
        stringBuilder.append("7.Addresses with Employee Count").append(System.lineSeparator());
        stringBuilder.append("8.Get Employee with Project").append(System.lineSeparator());
        stringBuilder.append("9.Find Latest 10 Projects").append(System.lineSeparator());
        stringBuilder.append("10.Increase Salaries").append(System.lineSeparator());
        stringBuilder.append("11.Find Employees by First Name").append(System.lineSeparator());
        stringBuilder.append("12.Employees Maximum Salaries").append(System.lineSeparator());
        stringBuilder.append("13.Remove Towns").append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
