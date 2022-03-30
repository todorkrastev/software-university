package com.manhattan.services.implementations;

import com.manhattan.common.exceptions.ProblemNotFoundException;
import com.manhattan.services.interfaces.Service;
import com.manhattan.services.interfaces.ServiceFactory;

import java.sql.Connection;

import static com.manhattan.common.Utilities.printRedMessage;

public class ServiceFactoryImpl implements ServiceFactory {
    private final Service villainsNamesService;
    private final Service minionsNamesService;
    private final Service addMinionsService;
    private final Service changeTownNamesCasingService;
    private final Service removeVillainService;
    private final Service printAllMinionNamesService;
    private final Service increaseMinionsAgeService;
    private final Service increaseAgeStoredProcedureService;

    public ServiceFactoryImpl(Connection connection) {
        this.villainsNamesService = new VillainsNamesServiceImpl(connection);
        this.minionsNamesService = new MinionNamesServiceImpl(connection);
        this.addMinionsService = new AddMinionsServiceImpl(connection);
        this.changeTownNamesCasingService = new ChangeTownNamesCasingServiceImlp(connection);
        this.removeVillainService = new RemoveVillainServiceImlp(connection);
        this.printAllMinionNamesService = new PrintAllMinionNamesServiceImlp(connection);
        this.increaseMinionsAgeService = new IncreaseMinionsAgeServiceImlp(connection);
        this.increaseAgeStoredProcedureService = new IncreaseAgeStoredProcedureServiceImlp(connection);
    }

    @Override
    public Service getService(int problemNumber) throws ProblemNotFoundException {
        return switch (problemNumber) {
            case 2 -> this.villainsNamesService;
            case 3 -> this.minionsNamesService;
            case 4 -> this.addMinionsService;
            case 5 -> this.changeTownNamesCasingService;
            case 6 -> this.removeVillainService;
            case 7 -> this.printAllMinionNamesService;
            case 8 -> this.increaseMinionsAgeService;
            case 9 -> this.increaseAgeStoredProcedureService;
            default -> throw new ProblemNotFoundException(problemNumber);
        };
    }
}
