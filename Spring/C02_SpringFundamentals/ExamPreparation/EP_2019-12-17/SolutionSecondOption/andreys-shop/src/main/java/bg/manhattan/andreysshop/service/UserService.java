package bg.manhattan.andreysshop.service;

import bg.manhattan.andreysshop.model.entity.User;
import bg.manhattan.andreysshop.model.service.UserServiceLoginModel;
import bg.manhattan.andreysshop.model.service.UserServiceModel;

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
