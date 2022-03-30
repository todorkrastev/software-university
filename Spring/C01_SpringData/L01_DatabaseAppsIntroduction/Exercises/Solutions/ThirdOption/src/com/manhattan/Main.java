package com.manhattan;

import com.manhattan.consoleApp.Application;
import com.manhattan.services.implementations.ServiceFactoryImpl;
import com.manhattan.services.interfaces.ServiceFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.manhattan.common.CommonConstants.*;
import static com.manhattan.common.Utilities.printRedMessage;
import static com.manhattan.common.Utilities.readStringFromConsole;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = initializeConnection();
            ServiceFactory factory = new ServiceFactoryImpl(connection);
            Application app = new Application(factory);
            app.run();
        } catch (SQLException | IOException e) {
            printRedMessage(e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static Connection initializeConnection() throws IOException, SQLException {
        Properties properties = getUsernameAndPassword();
        return DriverManager.getConnection(CONNECTION_STRING + DATABASE, properties);
    }

    private static Properties getUsernameAndPassword() throws IOException {
       printRedMessage("Peace enter your credentials for database!");
        Properties properties = new Properties();
        String user = readStringFromConsole("Enter user: ");
        properties.setProperty("user", user);
        String password = readStringFromConsole("Enter password: ");
        properties.setProperty("password", password);
        return properties;
    }
}
