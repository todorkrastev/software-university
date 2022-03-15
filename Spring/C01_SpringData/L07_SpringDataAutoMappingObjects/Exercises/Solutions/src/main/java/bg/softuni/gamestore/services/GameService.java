package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dtos.GameAddDto;
import bg.softuni.gamestore.models.entities.Game;

import java.math.BigDecimal;
import java.util.Set;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long id, BigDecimal price, BigDecimal size);

    void deleteGame(long id);

    void allGames();

    void detailGame(String title);

    Set<Game> getAll();
}
