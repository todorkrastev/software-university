package com.manhattan.services.implementations;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printResultMessage;

/**
 * 4.	Employees with Salary Over 50 000
 */
public class EmployeesWithSalaryOver50000Impl extends BaseServiceImpl {

    public EmployeesWithSalaryOver50000Impl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        TypedQuery<String> query = this.entityManager.createQuery("SELECT e.firstName " +
                "FROM Employee e " +
                "WHERE e.salary > :salary", String.class);

        query.setParameter("salary", BigDecimal.valueOf(50000));

        List<String> employeesNames = query.getResultList();

        printResultMessage(
                employeesNames.stream()
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
