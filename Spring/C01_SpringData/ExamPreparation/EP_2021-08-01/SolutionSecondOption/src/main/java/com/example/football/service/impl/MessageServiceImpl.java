package com.example.football.service.impl;

import com.example.football.service.MessageService;
import com.example.football.util.ValidationUtil;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private final ValidationUtil validator;

    public MessageServiceImpl(ValidationUtil validator) {
        this.validator = validator;
    }

    @Override
    public  <T> void addMessage(StringBuilder response, T dto, String additionalMessage) {
        String message;
        if (this.validator.isValid(dto)) {
            message = String.format("Successfully imported %s %s", dto.getClass().getSimpleName(), additionalMessage);
        } else {
            message = String.format("Invalid %s", dto.getClass().getSimpleName());
        }
        response.append(message).append(System.lineSeparator());
    }
}
