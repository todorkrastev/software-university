package com.manhattan;

import com.manhattan.services.implementations.ServiceFactoryImpl;
import com.manhattan.services.interfaces.ServiceFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ServiceFactory factory = new ServiceFactoryImpl(entityManager);
        Runnable engine = new Engine(factory);


        engine.run();

        entityManager.close();
    }
}
