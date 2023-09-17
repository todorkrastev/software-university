package bg.manhattan.gira.service;

import bg.manhattan.gira.model.service.TaskServiceModel;
import bg.manhattan.gira.model.view.TaskDto;

import java.util.List;

public interface TaskService {
    void add(TaskServiceModel map);

    List<TaskDto> getTasks();

    void progress(Long id);
}
