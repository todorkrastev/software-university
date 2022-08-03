package bg.manhattan.gira.model.view;

import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;
import bg.manhattan.gira.model.entity.enums.Progress;

import java.time.LocalDate;

public class TaskDto {
    private Long id;
    private String name;
    private String userUserName;
    private ClassificationNameEnum classificationName;
    private LocalDate dueDate;
    private Progress progress;

    public Long getId() {
        return id;
    }

    public TaskDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getUserUserName() {
        return userUserName;
    }

    public TaskDto setUserUserName(String userUserName) {
        this.userUserName = userUserName;
        return this;
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public TaskDto setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskDto setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public TaskDto setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }
}
