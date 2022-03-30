package com.manhattan.services.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Service {
    void execute() throws SQLException, IOException;
}
