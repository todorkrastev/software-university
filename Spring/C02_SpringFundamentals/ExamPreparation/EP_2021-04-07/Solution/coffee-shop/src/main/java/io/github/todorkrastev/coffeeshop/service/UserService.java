package io.github.todorkrastev.coffeeshop.service;

import io.github.todorkrastev.coffeeshop.model.entity.User;
import io.github.todorkrastev.coffeeshop.model.service.UserServiceModel;
import io.github.todorkrastev.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUsersByCountOfOrdersOrderedByCountDesc();
}
