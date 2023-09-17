package bg.manhattan.heroes.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueHeroNameValidator.class)
public @interface UniqueHeroName {
    String message() default "The hero name must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
