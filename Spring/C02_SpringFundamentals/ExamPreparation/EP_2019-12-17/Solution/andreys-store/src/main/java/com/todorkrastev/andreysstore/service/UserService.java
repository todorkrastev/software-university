package com.todorkrastev.andreysstore.service;

import com.todorkrastev.andreysstore.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
