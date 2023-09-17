package bg.manhattan.shoppinglist.service;

import bg.manhattan.shoppinglist.model.service.UserServiceLoginModel;
import bg.manhattan.shoppinglist.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userModel);

    boolean loginUser(UserServiceLoginModel userModel);

    void logout();

    boolean isLoggedIn();
}
