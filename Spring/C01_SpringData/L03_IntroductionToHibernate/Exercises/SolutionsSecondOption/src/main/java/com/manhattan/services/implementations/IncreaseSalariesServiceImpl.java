package com.manhattan.services.implementations;

import com.manhattan.entities.Employee;
import com.manhattan.services.interfaces.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printResultMessage;

/**
 * 10.	Increase Salaries
 */
public class IncreaseSalariesServiceImpl extends BaseServiceImpl {

    public IncreaseSalariesServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        Set<Integer> departmentIds = Set.of(1,2,4,11);


        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.createQuery(
                        "UPDATE Employee e " +
                                "SET e.salary = e.salary * 1.12 " +
                                "WHERE e.department.id IN :departments ")
                .setParameter("departments", departmentIds)
                .executeUpdate();
        transaction.commit();


        printResultMessage(this.entityManager.createQuery(
                        "SELECT e " +
                                "FROM Employee e " +
                                "WHERE e.department.id IN :departments", Employee.class)
                .setParameter("departments", departmentIds)
                .getResultStream()
                .map(e -> String.format("%s %s ($%.2f)", e.getFirstName(), e.getLastName(), e.getSalary()))
                .collect(Collectors.joining(System.lineSeparator()))
        );
    }
}
