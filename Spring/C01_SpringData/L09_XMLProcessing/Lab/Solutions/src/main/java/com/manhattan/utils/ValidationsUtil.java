package com.manhattan.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationsUtil {
    <E> boolean isValid(E entity);
    <E> Set<ConstraintViolation<E>> violation(E entity);
    <E> void validateModel(E model);
}
