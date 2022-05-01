package exam.util.impl;

import exam.util.MessageName;
import exam.util.MessageService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MessageServiceImpl implements MessageService {

    @Override
    public <T> String getMessage(T dto, boolean isValid) {
        String message;
        MessageName messageName = dto.getClass().getAnnotation(MessageName.class);
        String entityName = messageName == null ? dto.getClass().getSimpleName() : messageName.name();

        if (isValid) {
            message = String.format("Successfully imported %s %s", entityName, dto.toString());
        } else {
            message = String.format("Invalid %s", entityName);
        }
        return message;
    }
}
