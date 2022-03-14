package bg.softuni.gamestore.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

  <E> boolean isValid(E entity);

  <E> Set<ConstraintViolation<E>> getViolations(E entity);
}
