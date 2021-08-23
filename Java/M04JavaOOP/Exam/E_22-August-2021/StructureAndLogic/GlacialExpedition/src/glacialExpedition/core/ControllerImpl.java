package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private Mission mission;
    private static int countExploredStates = 0;


    public ControllerImpl() {
        this.setExplorerRepository();
        this.setStateRepository();
        this.setMission();
    }

    private void setExplorerRepository() {
        this.explorerRepository = new ExplorerRepository();
    }

    private void setStateRepository() {
        this.stateRepository = new StateRepository();
    }

    private void setMission() {
        this.mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = switch (type) {
            case "AnimalExplorer" -> new AnimalExplorer(explorerName);
            case "GlacierExplorer" -> new GlacierExplorer(explorerName);
            case "NaturalExplorer" -> new NaturalExplorer(explorerName);
            default -> throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        };
        this.explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        List<String> exhibitsToCollect = Arrays.asList(exhibits);
        state.getExhibits().addAll(exhibitsToCollect);
        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorerByGivenName = this.explorerRepository.byName(explorerName);
        if (explorerByGivenName == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        this.explorerRepository.remove(explorerByGivenName);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorersWithEnergyOverFifty = this.explorerRepository.getCollection().stream().filter(astronaut -> astronaut.getEnergy() > 50).collect(Collectors.toList());
        State stateByName = this.stateRepository.byName(stateName);
        int explorersBeforeMission = explorersWithEnergyOverFifty.size();
        if (explorersWithEnergyOverFifty.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        this.mission.explore(stateByName, explorersWithEnergyOverFifty);
        countExploredStates++;
        int explorersAfterMission = explorersWithEnergyOverFifty.size();
        int retiredExplorers = explorersBeforeMission - explorersAfterMission;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder output = new StringBuilder();
        output
                .append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, countExploredStates))
                        .append(System.lineSeparator())
                        .append(ConstantMessages.FINAL_EXPLORER_INFO);

        this.explorerRepository
                .getCollection()
                .forEach(explorer -> {
                    output
                            .append(System.lineSeparator())
                            .append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()))
                            .append(System.lineSeparator())
                            .append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
                    if (explorer.getSuitcase().getExhibits().isEmpty()) {
                        output
                                .append(System.lineSeparator())
                                .append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
                    } else {
                        output
                                .append(System.lineSeparator())
                                .append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
                    }
                });
        return output.toString().trim();
    }
}
