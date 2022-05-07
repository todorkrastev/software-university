package softuni.exam.util.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import softuni.exam.util.MessageName;
import softuni.exam.util.MessageService;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MessageServiceImpl implements MessageService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public <T> String getMessage(T dto, boolean isValid) {
        String message;
        MessageName messageName = dto.getClass().getAnnotation(MessageName.class);
        String entityName = messageName == null ? dto.getClass().getSimpleName() : messageName.name();

        if (isValid) {
            message = String.format("Successfully imported %s %s", entityName, dto.toString());
        } else {
            message = getRedMessage(String.format("Invalid %s", entityName));
        }
        return message;
    }

    private String getRedMessage(String message){
        return String.format("%s%s%s", ANSI_RED, message, ANSI_RESET);
    }
}
