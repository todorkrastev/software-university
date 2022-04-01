package com.manhattan.services.implementations;

import com.manhattan.entities.Address;
import com.manhattan.entities.Employee;
import com.manhattan.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.io.IOException;

import static com.manhattan.common.Utilities.*;

/**
 * 6.	Adding a New Address and Updating Employee
 */
public class АddingNewAddressАndUpdatingEmployeeServiceImpl extends BaseServiceImpl {

    public АddingNewAddressАndUpdatingEmployeeServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        try {
            String lastName = readStringFromConsole("Enter employee's last name: ");
            TypedQuery<Employee> query =
                    this.entityManager.createQuery(
                            "SELECT e " +
                                    "FROM Employee e " +
                                    "WHERE e.lastName = :lastName", Employee.class);
            query.setParameter("lastName", lastName);
            Employee employee = query.getResultList().stream().findFirst().orElse(null);
            if (employee != null) {
                EntityTransaction transaction = this.entityManager.getTransaction();
                transaction.begin();
                    Address address = createAddress("Vitoshka 15", "Sofia");
                    employee.setAddress(address);
                transaction.commit();
                printResultMessage(
                        String.format("The address of the employee \"%s %s\" was set to \"%s\" successfully.",
                                employee.getFirstName(), employee.getLastName(), address.getText()));
            } else {
                printRedMessage(String.format("Employee \"%s\" not found.", lastName));
            }
        } catch (IOException e) {
            printRedMessage(e.getMessage());
        }
    }

    private Address createAddress(String addressText, String townName) {
        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name =: townName", Town.class)
                .setParameter("townName", townName)
                .getResultStream()
                .findFirst()
                .orElse(null);

        Address address = new Address();
        address.setText(addressText);
        address.setTown(town);
        this.entityManager.persist(address);
        return address;
    }
}
