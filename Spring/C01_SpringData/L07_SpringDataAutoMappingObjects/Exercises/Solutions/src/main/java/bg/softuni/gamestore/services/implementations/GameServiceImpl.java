package bg.softuni.gamestore.services.implementations;

import bg.softuni.gamestore.models.dto.GameAddDto;
import bg.softuni.gamestore.models.entities.Game;
import bg.softuni.gamestore.repositories.GameRepository;
import bg.softuni.gamestore.services.GameService;
import bg.softuni.gamestore.services.UserService;
import bg.softuni.gamestore.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (!this.userService.hasLoggedInUser()) {
            System.out.println("To add a game you need to sign in to your account");
        } else {
            Set<ConstraintViolation<GameAddDto>> violations = this.validationUtil.getViolations(gameAddDto);

            if (!violations.isEmpty()) {
                violations
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            } else {
                Game game = this.modelMapper.map(gameAddDto, Game.class);
                // game.setImageThumbnail(gameAddDto.getThumbnailURL());

                this.gameRepository.save(game);

                System.out.println("Added game " + gameAddDto.getTitle());
            }
        }
    }
}
