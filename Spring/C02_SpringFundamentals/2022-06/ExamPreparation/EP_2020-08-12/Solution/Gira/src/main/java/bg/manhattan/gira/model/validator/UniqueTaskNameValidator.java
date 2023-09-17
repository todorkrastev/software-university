package bg.manhattan.gira.model.validator;

import bg.manhattan.gira.repository.TaskRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueTaskNameValidator implements ConstraintValidator<UniqueTaskName, String> {
    private final TaskRepository repository;

    public UniqueTaskNameValidator(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueTaskName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String taskName, ConstraintValidatorContext context) {
        return this.repository.findByName(taskName).isEmpty();
    }
}
