package bg.softuni.springdataintrolab;

import bg.softuni.springdataintrolab.exceptions.InsufficientFundsException;
import bg.softuni.springdataintrolab.exceptions.UsernameAlreadyExistsException;
import bg.softuni.springdataintrolab.services.AccountService;
import bg.softuni.springdataintrolab.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            this.userService.registerUser("Todor", 32, new BigDecimal(10000));
        } catch (UsernameAlreadyExistsException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        this.userService.addAccount(new BigDecimal(554), 1);

        try {
            this.accountService.withdrawMoney(new BigDecimal(130), 1L);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        this.accountService.transferMoney(new BigDecimal(200), 2L);
    }
}
