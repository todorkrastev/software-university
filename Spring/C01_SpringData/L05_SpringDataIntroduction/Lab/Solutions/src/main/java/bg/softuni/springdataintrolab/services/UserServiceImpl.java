package bg.softuni.springdataintrolab.services;

import bg.softuni.springdataintrolab.exceptions.UserNotFoundException;
import bg.softuni.springdataintrolab.exceptions.UsernameAlreadyExistsException;
import bg.softuni.springdataintrolab.models.Account;
import bg.softuni.springdataintrolab.models.User;
import bg.softuni.springdataintrolab.repositories.AccountRepository;
import bg.softuni.springdataintrolab.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(String username, int age, BigDecimal initialAmount) throws UsernameAlreadyExistsException {
        if (this.userRepository.existsByUsername(username)) {
            throw new UsernameAlreadyExistsException();
        }

        var user = new User();
        user.setUsername(username);
        user.setAge(age);

        this.userRepository.save(user);

        var firstAccount = new Account();
        firstAccount.setBalance(initialAmount);

        firstAccount.setUser(user);

        this.accountRepository.save(firstAccount);
    }

    @Override
    public void addAccount(BigDecimal amount, long id) throws UserNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        var newAccount = new Account();
        newAccount.setBalance(amount);
        newAccount.setUser(user);
        this.accountRepository.save(newAccount);
    }
}
