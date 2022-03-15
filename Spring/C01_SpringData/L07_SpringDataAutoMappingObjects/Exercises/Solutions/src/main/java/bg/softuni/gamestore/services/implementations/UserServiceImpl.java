package bg.softuni.gamestore.services.implementations;

import bg.softuni.gamestore.models.dtos.UserLoginDto;
import bg.softuni.gamestore.models.dtos.UserRegisterDto;
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
    private User currUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.currUser = null;
    }


    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!arePasswordAndConfirmPasswordSame(userRegisterDto)) {
            System.out.println("Password and confirm password must be same");
        } else {
            //  this.validationUtil.validateDtoModel(userRegisterDto);

            Set<ConstraintViolation<UserRegisterDto>> violations = this.validationUtil.getViolations(userRegisterDto);

            if (!violations.isEmpty()) {
                violations
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            } else {
                User user = this.modelMapper.map(userRegisterDto, User.class);
                makeUserAdminIfIsFirst(user);
                this.userRepository.saveAndFlush(user);
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
                    .findUserByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword())
                    .orElse(null);

            if (user == null) {
                System.out.println("Incorrect username / password");
            } else {
                this.currUser = user;
                System.out.println("Successfully logged in " + user.getFullName());
            }
        }
    }

    @Override
    public void logout() {
        if (this.currUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
        } else {
            System.out.printf("User %s successfully logged out %n", this.currUser.getFullName());

            this.currUser = null;
        }
    }

    @Override
    public boolean isAdminLogged() {
        boolean isAdmin = false;
        if (this.currUser != null) {
            isAdmin = this.currUser.isAdministrator();
        }
        return isAdmin;
    }

    @Override
    public User getCurrentUser() {
        if (this.currUser != null) {
            return this.currUser;
        }
        return null;
    }

    private void makeUserAdminIfIsFirst(User user) {
        if (this.userRepository.count() == 0) {
            user.setAdministrator(true);
        }
    }

    private boolean arePasswordAndConfirmPasswordSame(UserRegisterDto userRegisterDto) {
        return userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword());
    }
}
