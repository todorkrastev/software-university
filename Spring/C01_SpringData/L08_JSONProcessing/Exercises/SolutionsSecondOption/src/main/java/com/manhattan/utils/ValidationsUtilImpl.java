package com.manhattan.utils;

import org.modelmapper.ValidationException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ValidationsUtilImpl implements ValidationsUtil {
    private final Validator validator;

    public ValidationsUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return this.violation(entity).isEmpty();
    }

    @Override
    public <E> Set<ConstraintViolation<E>> violation(E entity) {
        return validator.validate(entity);
    }


    private <E> List<ErrorMessage> violationMessages(E entity) {
        return this.violation(entity).stream()
                .map(ConstraintViolation::getMessage)
                .map(ErrorMessage::new)
                .collect(Collectors.toList());
    }

    @Override
    public <E> void validateModel(E model) {
        List<ErrorMessage> violations = this.violationMessages(model);
        if(!violations.isEmpty()){
            throw new ValidationException(violations);
        }
    }
}
