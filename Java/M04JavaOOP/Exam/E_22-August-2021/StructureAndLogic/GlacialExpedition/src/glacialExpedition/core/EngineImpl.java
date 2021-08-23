package glacialExpedition.core;

import glacialExpedition.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        result = switch (command) {
            case AddExplorer -> addExplorer(data);
            case AddState -> addState(data);
            case RetireExplorer -> retireExplorer(data);
            case ExploreState -> exploreState(data);
            case FinalResult -> finalResult();
            case Exit -> Command.Exit.name();
        };

        return result;
    }

    private String retireExplorer(String[] data) {
        return controller.retireExplorer(data[0]);
    }

    private String finalResult() {
        return controller.finalResult();
    }

    private String exploreState(String[] data) {
        return controller.exploreState(data[0]);
    }

    private String addState(String[] data) {
        String stateName = data[0];
        String[] exhibits = Arrays.stream(data).skip(1).toArray(String[]::new);
        return controller.addState(stateName, exhibits);
    }

    private String addExplorer(String[] data) {
        return controller.addExplorer(data[0], data[1]);
    }
}
