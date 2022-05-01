package com.example.football.util;

import org.springframework.stereotype.Service;

import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class ValidationUtilImpl implements ValidationUtil {
    @Override
    public <E> boolean isValid(E entity) {
        Validator validator = Validation
                .buildDefaultValidatorFactory().getValidator();
        return validator.validate(entity).isEmpty();
    }
}
