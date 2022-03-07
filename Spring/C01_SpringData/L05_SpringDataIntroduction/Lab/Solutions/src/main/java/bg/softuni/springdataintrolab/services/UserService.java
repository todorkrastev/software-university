package bg.softuni.springdataintrolab.services;


import bg.softuni.springdataintrolab.exceptions.UserNotFoundException;
import bg.softuni.springdataintrolab.exceptions.UsernameAlreadyExistsException;

import java.math.BigDecimal;

public interface UserService {

    void registerUser(String username, int age, BigDecimal initialAmount) throws UsernameAlreadyExistsException;

    void addAccount(BigDecimal amount, long id) throws UserNotFoundException;
}
