package bg.softuni.gamestore.services.implementations;

import bg.softuni.gamestore.models.dto.UserLoginDto;
import bg.softuni.gamestore.models.dto.UserRegisterDto;
import bg.softuni.gamestore.models.entities.User;
import bg.softuni.gamestore.repositories.UserRepository;
import bg.softuni.gamestore.services.UserService;
import bg.softuni.gamestore.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("Passwords do not match!");
        } else {
            Set<ConstraintViolation<UserRegisterDto>> violations = this.validationUtil.getViolations(userRegisterDto);

            if (!violations.isEmpty()) {
                violations
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            } else {
                User user = this.modelMapper.map(userRegisterDto, User.class);

                this.userRepository.save(user);

                System.out.printf("%s was registered%n", user.getFullName());
            }
        }
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations = this.validationUtil.getViolations(userLoginDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            User user = this.userRepository
                    .findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword())
                    .orElse(null);

            if (user == null) {
                System.out.println("Incorrect username / password");
            } else {
                this.loggedInUser = user;
            }
        }
    }

    @Override
    public void logoutUser() {
        if (this.loggedInUser == null) {
            System.out.println("Cannot logout. No user was logged in");
        } else {
            System.out.printf("User %s successfully logged out%n", this.loggedInUser.getFullName());

            this.loggedInUser = null;
        }
    }

    @Override
    public boolean hasLoggedInUser() {
        return this.loggedInUser != null;
    }
}
