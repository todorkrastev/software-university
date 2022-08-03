package bg.manhattan.gira.model.service;

import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;

import java.time.LocalDate;

public class TaskServiceModel {
    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationNameEnum classification;

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }
}
