package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dtos.UserLoginDto;
import bg.softuni.gamestore.models.dtos.UserRegisterDto;
import bg.softuni.gamestore.models.entities.User;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isAdminLogged();

    User getCurrentUser();
}
