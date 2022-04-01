package com.manhattan.services.implementations;

import com.manhattan.models.ProjectModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.printResultMessage;

/**
 * 9.	Find Latest 10 Projects
 */
public class FindLatestTenProjectsServiceImpl extends BaseServiceImpl {


    public static final int RESULTS_LIMIT = 10;

    public FindLatestTenProjectsServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {

        TypedQuery<ProjectModel> query = this.entityManager.createQuery(
                "SELECT NEW com.manhattan.models.ProjectModel(p.name, p.description, p.startDate, p.endDate) " +
                        "FROM Project p " +
                        "WHERE p.startDate IS NOT NULL " +
                        "ORDER BY p.startDate DESC", ProjectModel.class);


        query.setMaxResults(RESULTS_LIMIT);
        List<ProjectModel> projects = query.getResultList();

        String resultMessage =
                (projects.isEmpty()) ? "No results Found" :
                        projects.stream()
                                .sorted(Comparator.comparing(ProjectModel::getName))
                                .map(ProjectModel::toString)
                                .collect(Collectors.joining(System.lineSeparator()));

        printResultMessage(resultMessage);
    }
}
