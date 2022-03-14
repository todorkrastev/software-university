package bg.softuni.gamestore;

import bg.softuni.gamestore.models.dto.GameAddDto;
import bg.softuni.gamestore.models.dto.UserLoginDto;
import bg.softuni.gamestore.models.dto.UserRegisterDto;
import bg.softuni.gamestore.services.GameService;
import bg.softuni.gamestore.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader reader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(BufferedReader reader, UserService userService, GameService gameService) {
        this.reader = reader;
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Please, enter your command:");
            String[] split = this.reader.readLine().trim().split("\\|");
            String command = split[0].toLowerCase();

            switch (command) {
                case "registeruser" -> this.userService
                        .registerUser(
                                new UserRegisterDto(split[1], split[2], split[3], split[4]));
                case "loginuser" -> this.userService
                        .loginUser(
                                new UserLoginDto(split[1], split[2]));
                case "logout" -> this.userService
                        .logoutUser();
                case "addgame" -> this.gameService
                        .addGame(
                                new GameAddDto(split[1], new BigDecimal(split[2]), Double.parseDouble(split[3]),
                                        split[4], split[5], split[6], split[7]));
            }
        }
    }
}
