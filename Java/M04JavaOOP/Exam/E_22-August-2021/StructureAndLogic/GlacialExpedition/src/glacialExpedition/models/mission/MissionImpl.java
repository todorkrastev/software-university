package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<Explorer> explorersWithEnergy = explorers.stream().filter(Explorer::canSearch).collect(Collectors.toList());
        List<String> exhibitsToCollect = new ArrayList<>(state.getExhibits());

        for (Explorer currExplorer : explorersWithEnergy) {
            for (int exhibit = 0; exhibit < exhibitsToCollect.size(); exhibit++) {
                if (exhibitsToCollect.stream().iterator().hasNext()) {
                    String currExhibit = exhibitsToCollect.stream().iterator().next();
                    currExplorer.getSuitcase().getExhibits().add(currExhibit);
                    exhibitsToCollect.remove(exhibit);
                    exhibit--;
                    currExplorer.search();
                }
                if (!currExplorer.canSearch()) {
                    explorers.remove(currExplorer);
                    break;
                }
                if (isExhibitsToCollectHasNext(exhibitsToCollect)) break;
            }
            if (isExhibitsToCollectHasNext(exhibitsToCollect)) break;
        }
    }

    private boolean isExhibitsToCollectHasNext(List<String> exhibitsToCollect) {
        return !exhibitsToCollect.stream().iterator().hasNext();
    }
}
