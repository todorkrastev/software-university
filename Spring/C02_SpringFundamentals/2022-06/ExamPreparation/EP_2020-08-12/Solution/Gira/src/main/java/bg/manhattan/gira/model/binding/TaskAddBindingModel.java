package bg.manhattan.gira.model.binding;

import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;
import bg.manhattan.gira.model.validator.UniqueTaskName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {
    /**
     * Name length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @Size(min=5, max = 20, message = "Name length must be between 3 and 20 characters")
    @UniqueTaskName
    private String name;

    /**
     * Description min length must be minimum 5(inclusive) characters
     */
    @Size(min=5, message = "Description length must be more than 5 characters!")
    private String description;


    /**
     * A date, that cannot be in the past
     */
    @NotNull(message="Due date is required")
    @FutureOrPresent(message = "The date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotNull(message = "Classification cannot be null!")
    private ClassificationNameEnum classification;

    public String getName() {
        return name;
    }

    public TaskAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public TaskAddBindingModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }
}
