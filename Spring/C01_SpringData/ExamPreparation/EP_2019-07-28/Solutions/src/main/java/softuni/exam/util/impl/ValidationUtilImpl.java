package softuni.exam.util.impl;

import org.springframework.stereotype.Service;
import softuni.exam.util.ValidationUtil;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.function.Predicate;

@Service
public class ValidationUtilImpl implements ValidationUtil {
    @Override
    public <E> boolean isValid(E entity) {
        Validator validator = Validation
                .buildDefaultValidatorFactory().getValidator();
        return validator.validate(entity).isEmpty();
    }

    @Override
    public <E> boolean isValid(E entity, Predicate<E> isValid) {
        Validator validator = Validation
                .buildDefaultValidatorFactory().getValidator();
        return validator.validate(entity).isEmpty() && isValid.test(entity);
    }
}
