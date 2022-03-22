package bg.softuni.productshop.utils.implementations;

import bg.softuni.productshop.utils.ValidationUtil;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }


    @Override
    public <T> boolean isValid(T entity) {
        return this.validator.validate(entity).isEmpty();
    }
}
