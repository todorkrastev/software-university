package softuni.exam.util;

public interface MessageService {
    <T> String getMessage(T dto, boolean isValid);
}
