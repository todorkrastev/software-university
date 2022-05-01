package com.example.football.service;

public interface MessageService {
    <T> void addMessage(StringBuilder response, T dto, String additionalMessage);
}
