package bg.manhattan.gira.service.impl;

import bg.manhattan.gira.model.entity.Classification;
import bg.manhattan.gira.model.entity.Task;
import bg.manhattan.gira.model.entity.User;
import bg.manhattan.gira.model.entity.enums.Progress;
import bg.manhattan.gira.model.service.TaskServiceModel;
import bg.manhattan.gira.model.view.TaskDto;
import bg.manhattan.gira.repository.TaskRepository;
import bg.manhattan.gira.service.ClassificationService;
import bg.manhattan.gira.service.TaskService;
import bg.manhattan.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final ModelMapper mapper;
    private final UserService userService;
    private final ClassificationService classificationService;

    public TaskServiceImpl(TaskRepository repository,
                           ModelMapper mapper,
                           UserService userService,
                           ClassificationService classificationService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userService = userService;
        this.classificationService = classificationService;
    }

    @Override
    public void add(TaskServiceModel taskModel) {
        User user = this.userService.getCurrentUser()
                .orElseThrow(()->new IllegalArgumentException("User not found!"));
        Classification classification = this.classificationService.findByName(taskModel.getClassification())
                .orElseThrow(()->new IllegalArgumentException("Classification not found!"));

        Task task = this.mapper.map(taskModel, Task.class)
                .setUser(user)
                .setClassification(classification)
                .setProgress(Progress.OPEN);
        this.repository.save(task);
    }

    @Override
    public List<TaskDto> getTasks() {
        return this.repository.findAllByProgressLessThan(Progress.OTHER)
                .stream()
                .map(task -> this.mapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void progress(Long id) {
        Task task = this.repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Task not found!"));
        Progress progress = task.getProgress();
        if (progress.hasNextStatus()){
            task.setProgress(progress.getNext());
            this.repository.save(task);
        }
    }
}
