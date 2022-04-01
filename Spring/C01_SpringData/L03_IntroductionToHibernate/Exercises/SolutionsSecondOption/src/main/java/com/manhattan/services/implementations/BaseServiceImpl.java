package com.manhattan.services.implementations;

import com.manhattan.services.interfaces.Service;

import javax.persistence.EntityManager;

public abstract class BaseServiceImpl implements Service {
    protected final EntityManager entityManager;

    public BaseServiceImpl(EntityManager entityManager) {
        if (entityManager == null) throw new IllegalArgumentException("Argument 'entityManager' cannot be null!");
        this.entityManager = entityManager;
    }
}
