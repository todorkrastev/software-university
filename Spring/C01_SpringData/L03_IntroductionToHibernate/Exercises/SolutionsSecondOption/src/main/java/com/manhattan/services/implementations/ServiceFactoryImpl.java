package com.manhattan.services.implementations;

import com.manhattan.common.exceptions.ProblemNotFoundException;
import com.manhattan.services.interfaces.Service;
import com.manhattan.services.interfaces.ServiceFactory;

import javax.persistence.EntityManager;

public class ServiceFactoryImpl implements ServiceFactory {
    private final Service changeCasingService;
    private final Service containsEmployeeService;
    private final Service employeesWithSalaryOver50000;
    private final Service employeesFromDepartment;
    private final Service addingNewAddressAndUpdatingEmployee;
    private final Service addressesWithEmployeeCount;
    private final Service getEmployeeWithProject;
    private final Service findLatestTenProjects;
    private final Service increaseSalaries;
    private final Service findEmployeesByFirstName;
    private final Service employeesMaximumSalaries;
    private final Service removeTowns;


    public ServiceFactoryImpl(EntityManager entityManager) {
        this.changeCasingService = new ChangeCasingServiceImpl(entityManager);
        this.containsEmployeeService = new ContainsEmployeeServiceImpl(entityManager);
        this.employeesWithSalaryOver50000 = new EmployeesWithSalaryOver50000Impl(entityManager);
        this.employeesFromDepartment = new EmployeesFromDepartmentImpl(entityManager);
        this.addingNewAddressAndUpdatingEmployee = new АddingNewAddressАndUpdatingEmployeeServiceImpl(entityManager);
        this.addressesWithEmployeeCount = new AddressesWithEmployeeCountServiceImpl(entityManager);
        this.getEmployeeWithProject = new GetEmployeeWithProjectServiceImpl(entityManager);
        this.findLatestTenProjects = new FindLatestTenProjectsServiceImpl(entityManager);
        this.increaseSalaries = new IncreaseSalariesServiceImpl(entityManager);
        this.findEmployeesByFirstName = new FindEmployeesByFirstNameServiceImpl(entityManager);
        this.employeesMaximumSalaries = new EmployeesMaximumSalariesServiceImpl(entityManager);
        this.removeTowns = new RemoveTownsServiceImpl(entityManager);
    }

    @Override
    public Service getService(int problemNumber) throws ProblemNotFoundException {
        return switch (problemNumber) {
            case 2 -> this.changeCasingService;
            case 3 -> this.containsEmployeeService;
            case 4 -> this.employeesWithSalaryOver50000;
            case 5 -> this.employeesFromDepartment;
            case 6 -> this.addingNewAddressAndUpdatingEmployee;
            case 7 -> this.addressesWithEmployeeCount;
            case 8 -> this.getEmployeeWithProject;
            case 9 -> this.findLatestTenProjects;
            case 10 -> this.increaseSalaries;
            case 11 -> this.findEmployeesByFirstName;
            case 12 -> this.employeesMaximumSalaries;
            case 13 -> this.removeTowns;
            default -> throw new ProblemNotFoundException(problemNumber);
        };
    }
}
