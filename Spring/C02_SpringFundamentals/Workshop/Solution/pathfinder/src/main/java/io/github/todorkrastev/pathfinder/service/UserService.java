package io.github.todorkrastev.pathfinder.service;

import io.github.todorkrastev.pathfinder.model.entity.User;
import io.github.todorkrastev.pathfinder.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    UserServiceModel findById(Long id);

    boolean doesNameExist(String username);

    User findCurrentLoginUserEntity();
}
