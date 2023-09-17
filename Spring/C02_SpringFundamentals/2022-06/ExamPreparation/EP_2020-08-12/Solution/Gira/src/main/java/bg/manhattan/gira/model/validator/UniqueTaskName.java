package bg.manhattan.gira.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueTaskNameValidator.class)
public @interface UniqueTaskName {
    String message() default "The task name must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
