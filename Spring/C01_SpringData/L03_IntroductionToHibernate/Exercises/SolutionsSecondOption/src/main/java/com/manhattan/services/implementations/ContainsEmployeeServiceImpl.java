package com.manhattan.services.implementations;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.IOException;

import static com.manhattan.common.Utilities.*;

/**
 * 3.	Contains Employee
 */
public class ContainsEmployeeServiceImpl extends BaseServiceImpl {

    public ContainsEmployeeServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        try {
            String[] fullName = readStringFromConsole("Enter employee's name: ").split("\\s+");
            String firstName = fullName[0];
            String lastName = fullName[1];

            TypedQuery<Long> query = this.entityManager.createQuery("SELECT COUNT (e) " +
                    "FROM Employee e " +
                    "WHERE e.firstName = :firstName " +
                    "AND e.lastName = :lastName", Long.class);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);

            Long employeesCount = query.getSingleResult();
            String message = (employeesCount == 0) ? "No" : "Yes";

            printResultMessage(message);

        } catch (IOException e) {
            printRedMessage(e.getMessage());
        }

    }
}
