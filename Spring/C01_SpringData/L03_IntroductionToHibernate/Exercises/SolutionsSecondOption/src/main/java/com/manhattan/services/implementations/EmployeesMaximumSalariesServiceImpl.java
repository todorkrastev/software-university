package com.manhattan.services.implementations;

import com.manhattan.entities.Employee;
import com.manhattan.models.DepartmentMaxSalaryModel;
import com.manhattan.services.interfaces.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printResultMessage;

/**
 * 12.	Employees Maximum Salaries
 */
public class EmployeesMaximumSalariesServiceImpl extends BaseServiceImpl {

    public EmployeesMaximumSalariesServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        printResultMessage(
                this.entityManager
                        .createQuery(
                                "SELECT NEW com.manhattan.models.DepartmentMaxSalaryModel(e.department.name, MAX(e.salary)) " +
                                        "FROM Employee e " +
                                        "GROUP BY e.department.id " +
                                        "HAVING MAX(e.salary) NOT BETWEEN :minSalary AND :maxSalary",
                                DepartmentMaxSalaryModel.class)
                        .setParameter("minSalary", BigDecimal.valueOf(30000))
                        .setParameter("maxSalary", BigDecimal.valueOf(70000))
                        .getResultStream()
                        .map(DepartmentMaxSalaryModel::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
