package softuni.exam.util;

import java.util.function.Predicate;

public interface ValidationUtil {
    <E> boolean isValid(E entity);

    <E> boolean isValid(E entity, Predicate<E> isValid);
}
