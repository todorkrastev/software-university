package bg.manhattan.heroes.service;

import bg.manhattan.heroes.model.entity.User;
import bg.manhattan.heroes.model.service.UserServiceLoginModel;
import bg.manhattan.heroes.model.service.UserServiceModel;

import java.util.Optional;

public interface UserService {
    void registerUser(UserServiceModel userModel);

    boolean loginUser(UserServiceLoginModel userModel);

    void logout();

    boolean isLoggedIn();

    Optional<User> getCurrentUser();

    String getCurrentUserName();

    Optional<UserServiceModel> getUserByUsername(String userName);

    Optional<UserServiceModel> getUserByEmail(String email);
}
