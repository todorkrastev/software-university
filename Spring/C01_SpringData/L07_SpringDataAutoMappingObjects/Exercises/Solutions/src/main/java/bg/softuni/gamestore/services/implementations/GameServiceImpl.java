package bg.softuni.gamestore.services.implementations;

import bg.softuni.gamestore.models.dtos.GameAddDto;
import bg.softuni.gamestore.models.dtos.GameDetailsDto;
import bg.softuni.gamestore.models.dtos.GameViewDto;
import bg.softuni.gamestore.models.entities.Game;
import bg.softuni.gamestore.repositories.GameRepository;
import bg.softuni.gamestore.services.GameService;
import bg.softuni.gamestore.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations = this.validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            Game game = this.modelMapper.map(gameAddDto, Game.class);

            this.gameRepository.saveAndFlush(game);

            System.out.println("Added " + gameAddDto.getTitle());
        }

    }

    @Override
    public void editGame(long id, BigDecimal price, BigDecimal size) {
        Game game = this.gameRepository
                .findById(id)
                .orElse(null);

        if (game == null) {
            System.out.printf("Game with id %d does not exist in the system", id);
        } else {
            game.setPrice(price);
            game.setSize(size);

            this.gameRepository.saveAndFlush(game);

            System.out.println("Edited " + game.getTitle());
        }
    }

    @Override
    @Transactional
    public void deleteGame(long id) {
        Game game = this.gameRepository
                .findById(id)
                .orElse(null);


        if (game == null) {
            System.out.printf("Game with id %d does not exist in the system", id);
        } else {
            this.gameRepository
                    .deleteOneById(id);

            System.out.println("Deleted " + game.getTitle());
        }
    }

    @Override
    public void allGames() {
        this.gameRepository
                .findAll()
                .stream()
                .map(game -> this.modelMapper.map(game, GameViewDto.class))
                .map(GameViewDto::toString)
                .forEach(System.out::println);
    }

    @Override
    public void detailGame(String title) {
        Game game = this.gameRepository
                .findOneByTitle(title)
                .orElse(null);

        if (game == null) {
            System.out.printf("Game %s does not exist in the system%n", title);
        } else {
            this.gameRepository
                    .findOneByTitle(title)
                    .stream()
                    .map(gameDetail -> this.modelMapper.map(gameDetail, GameDetailsDto.class))
                    .map(GameDetailsDto::toString)
                    .forEach(System.out::println);
        }
    }

    @Override
    public Set<Game> getAll() {
        return  this.gameRepository.findAllBy();
    }
}
