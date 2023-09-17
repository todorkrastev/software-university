package com.todorkrastev.shoppinglist.service;

import com.todorkrastev.shoppinglist.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
