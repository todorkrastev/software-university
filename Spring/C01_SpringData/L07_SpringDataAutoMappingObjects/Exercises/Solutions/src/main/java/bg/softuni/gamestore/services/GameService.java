package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dto.GameAddDto;

public interface GameService {
    void addGame(GameAddDto gameAddDto);
}
