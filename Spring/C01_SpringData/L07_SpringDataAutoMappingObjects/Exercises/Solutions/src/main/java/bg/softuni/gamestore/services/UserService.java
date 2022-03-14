package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dto.UserLoginDto;
import bg.softuni.gamestore.models.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logoutUser();

    boolean hasLoggedInUser();
}
