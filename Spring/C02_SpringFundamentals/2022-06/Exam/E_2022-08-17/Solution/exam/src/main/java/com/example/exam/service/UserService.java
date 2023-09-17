package com.example.exam.service;

import com.example.exam.model.entity.User;
import com.example.exam.model.service.UserServiceLoginModel;
import com.example.exam.model.service.UserServiceModel;

import java.util.Optional;

public interface UserService {
    boolean isLoggedIn();

    boolean loginUser(UserServiceLoginModel userModel);

    void logout();

    Optional<UserServiceModel> getUserByUsername(String userName);

    Optional<UserServiceModel> getUserByEmail(String email);

    void registerUser(UserServiceModel userModel);

    User getCurrentUser();
}
