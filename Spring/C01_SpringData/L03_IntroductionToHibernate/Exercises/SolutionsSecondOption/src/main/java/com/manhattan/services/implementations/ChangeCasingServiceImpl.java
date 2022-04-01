package com.manhattan.services.implementations;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import static com.manhattan.common.Utilities.printResultMessage;

/**
 * 2.	Change casing
 */
public class ChangeCasingServiceImpl extends BaseServiceImpl {
    public ChangeCasingServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("UPDATE Town t " +
                "SET t.name = upper(t.name) " +
                "WHERE length(t.name) <= 5");

        int affectedEntities = query.executeUpdate();
        transaction.commit();
        printResultMessage(String.format("%d records affected!",affectedEntities));
    }
}
