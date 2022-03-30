package com.manhattan.services.implementations;

import com.manhattan.services.interfaces.Service;

import java.sql.Connection;

public abstract class BaseServiceImpl implements Service {
    protected final Connection connection;

    public BaseServiceImpl(Connection connection) {
        if (connection == null) throw new IllegalArgumentException("Argument 'connection' cannot be null!");
        this.connection = connection;
    }
}
