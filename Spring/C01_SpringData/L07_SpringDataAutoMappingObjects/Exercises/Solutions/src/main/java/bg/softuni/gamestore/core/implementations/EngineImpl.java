package bg.softuni.gamestore.core.implementations;

import bg.softuni.gamestore.core.Engine;
import bg.softuni.gamestore.models.dtos.GameAddDto;
import bg.softuni.gamestore.models.dtos.UserLoginDto;
import bg.softuni.gamestore.models.dtos.UserRegisterDto;
import bg.softuni.gamestore.models.entities.Game;
import bg.softuni.gamestore.services.GameService;
import bg.softuni.gamestore.services.OrderService;
import bg.softuni.gamestore.services.UserService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class EngineImpl implements Engine {
    private final BufferedReader reader;
    private final UserService userService;
    private final GameService gameService;
    private final OrderService orderService;

    public EngineImpl(BufferedReader reader, UserService userService, GameService gameService, OrderService orderService) {
        this.reader = reader;
        this.userService = userService;
        this.gameService = gameService;
        this.orderService = orderService;
    }

    @Override
    public void run() throws IOException {
        printWelcomeMessage();

        do {
            printRunningMessage();

            try {
                String[] split = reader.readLine().trim().split("\\|");

                switch (split[0].toLowerCase()) {
                    case "registeruser" -> registerUser(split);
                    case "loginuser" -> loginUser(split);
                    case "logout" -> logout();
                    case "addgame" -> addGame(split);
                    case "editgame" -> editGame(split);
                    case "deletegame" -> deleteGame(split);
                    case "allgames" -> allGames();
                    case "detailgame" -> detailGame(split);
                    case "ownedgames" -> ownedGames();
                    default -> System.out.println("Invalid command!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isProgramRunning());

        printGoodbyeMessage();
    }

    private void ownedGames() {
        if (this.userService.getCurrentUser() == null) {
            System.out.println("You must be logged in to make the following request");
        } else {
            getItemsInShoppingBasket();

            this.userService
                    .getCurrentUser()
                    .getGames()
                    .stream()
                    .map(Game::getTitle)
                    .forEach(System.out::println);
        }
    }

    private void getItemsInShoppingBasket() {
      this.userService.getCurrentUser().setGames(this.gameService.getAll());
    }

    private void detailGame(String[] split) {
        this.gameService
                .detailGame(split[1]);
    }

    private void allGames() {
        this.gameService
                .allGames();
    }

    private void deleteGame(String[] split) {
        if (!this.userService.isAdminLogged()) {
            System.out.println("You must be admin to perform this action.");
        } else {
            this.gameService
                    .deleteGame(Long.parseLong(split[1]));
        }
    }

    private void editGame(String[] split) {
        if (!this.userService.isAdminLogged()) {
            System.out.println("You must be admin to perform this action.");
        } else {
            this.gameService
                    .editGame(Long.parseLong(split[1]),
                            BigDecimal.valueOf(Double.parseDouble(split[2].trim().split("=")[1])),
                            BigDecimal.valueOf(Double.parseDouble(split[3].trim().split("=")[1])));
        }
    }

    private void addGame(String[] split) {
        if (!this.userService.isAdminLogged()) {
            System.out.println("You must be admin to perform this action.");
        } else {
            this.gameService
                    .addGame(new GameAddDto(split[1], BigDecimal.valueOf(Double.parseDouble(split[2])),
                            BigDecimal.valueOf(Double.parseDouble(split[3])),
                            split[4], split[5], split[6], split[7]));
        }
    }

    private void logout() {
        this.userService
                .logout();
    }

    private void loginUser(String[] split) {
        this.userService
                .loginUser(new UserLoginDto(split[1], split[2]));
    }


    private void registerUser(String[] split) {
        this.userService
                .registerUser(new UserRegisterDto(split[1], split[2], split[3], split[4]));
    }

    private void printGoodbyeMessage() {
        System.out.println("Thank you for spending your time exploring my code!");
        printSeparatorLine();
    }

    private boolean isProgramRunning() throws IOException {
        printSeparatorLine();

        String answer;
        do {
            System.out.println("Would you like to continue exploring more commands?: [Y/N]");
            answer = this.reader.readLine().trim().toLowerCase();

            printSeparatorLine();
        } while (!answer.equals("n") && !answer.equals("y"));
        return !answer.equals("y");
    }

    private void printRunningMessage() {
        System.out.println("Please, enter your command:");
    }

    private void printWelcomeMessage() {
        printSeparatorLine();
        System.out.println("Hello There! Welcome to my code!");
        printSeparatorLine();
    }

    private void printSeparatorLine() {
        System.out.println("*".repeat(150));
    }
}
