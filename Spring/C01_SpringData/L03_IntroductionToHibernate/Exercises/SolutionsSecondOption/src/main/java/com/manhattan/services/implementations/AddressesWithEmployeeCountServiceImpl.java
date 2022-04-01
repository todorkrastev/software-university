package com.manhattan.services.implementations;

import com.manhattan.models.AddressModel;
import com.manhattan.services.interfaces.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printResultMessage;

/**
 * 7.	Addresses with Employee Count
 */
public class AddressesWithEmployeeCountServiceImpl extends BaseServiceImpl {

    public static final int RESULTS_LIMIT = 10;

    public AddressesWithEmployeeCountServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {

        TypedQuery<AddressModel> query = this.entityManager.createQuery(
                "SELECT NEW com.manhattan.models.AddressModel(a.text, a.town.name, a.employees.size)" +
                        "FROM Address a " +
                        "ORDER BY a.employees.size DESC", AddressModel.class);

        query.setMaxResults(RESULTS_LIMIT);
        List<AddressModel> addresses = query.getResultList();

        printResultMessage(addresses.stream()
                .map(AddressModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
