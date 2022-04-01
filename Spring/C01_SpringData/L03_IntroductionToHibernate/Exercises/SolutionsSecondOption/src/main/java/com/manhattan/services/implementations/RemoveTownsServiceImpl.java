package com.manhattan.services.implementations;

import com.manhattan.entities.Address;
import com.manhattan.entities.Employee;
import com.manhattan.entities.Town;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

import static com.manhattan.common.Utilities.printResultMessage;
import static com.manhattan.common.Utilities.readStringFromConsole;

public class RemoveTownsServiceImpl extends BaseServiceImpl {

    public RemoveTownsServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        try {
            String townName = readStringFromConsole("Enter town name: ");
            List<Address> addresses = getAddressesByTownName(townName);

            this.entityManager.getTransaction().begin();

            for (Address address : addresses) {
                for (Employee employee : address.getEmployees()) {
                    employee.setAddress(null);
                }
                this.entityManager.remove(address);
            }

            Town town = getTownByTownName(townName);

            this.entityManager.remove(town);

            if (addresses.size() == 1) {
               printResultMessage(String.format("1 address in %s deleted%n", townName));
            } else {
                printResultMessage(String.format("%d addresses in %s deleted%n", addresses.size(), townName));
            }

            this.entityManager.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Town getTownByTownName(String townName) {
        return this.entityManager.createQuery(
                        "SELECT t FROM Town t WHERE t.name = :townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();
    }

    private List<Address> getAddressesByTownName(String townName) {
        return this.entityManager.createQuery
                        ("SELECT a FROM Address a WHERE a.town.name = :townName", Address.class)
                .setParameter("townName", townName)
                .getResultList();
    }


}
