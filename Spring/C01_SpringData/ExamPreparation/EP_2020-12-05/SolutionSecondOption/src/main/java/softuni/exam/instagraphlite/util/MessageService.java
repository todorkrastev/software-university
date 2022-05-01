package softuni.exam.instagraphlite.util;

public interface MessageService {
    <T> String getMessage(T dto, boolean isValid);
}
