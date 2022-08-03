package bg.manhattan.gira.model.view;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {
    private final List<TaskDto> tasks;

    public HomeViewModel() {
        this(new ArrayList<>());
    }

    public HomeViewModel(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }
}
