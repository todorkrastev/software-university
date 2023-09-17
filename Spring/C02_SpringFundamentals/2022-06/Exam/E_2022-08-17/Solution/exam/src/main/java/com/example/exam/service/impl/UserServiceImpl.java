package com.example.exam.service.impl;

import com.example.exam.model.entity.User;
import com.example.exam.model.service.UserServiceLoginModel;
import com.example.exam.model.service.UserServiceModel;
import com.example.exam.repository.UserRepository;
import com.example.exam.service.UserService;
import com.example.exam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(CurrentUser currentUser, UserRepository userRepository, ModelMapper mapper) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean isLoggedIn() {
        return this.currentUser.isLoggedIn();
    }

    @Override
    public boolean loginUser(UserServiceLoginModel userModel) {
        Optional<User> dbUser = this.userRepository.findByUsername(userModel.getUsername());
        if (dbUser.isEmpty()) {
            return false;
        }

        boolean matches = userModel.getPassword().equals(dbUser.get().getPassword());
        if (!matches) {
            return false;
        }

        User user = dbUser.get();
        this.currentUser
                .setId(user.getId())
                .setUsername(user.getUsername());
        return true;
    }

    @Override
    public void logout() {
        this.currentUser.clear();
    }

    @Override
    public Optional<UserServiceModel> getUserByUsername(String userName) {
        Optional<User> user = this.userRepository.findByUsername(userName);
        return toUserServiceModel(user);
    }

    @Override
    public Optional<UserServiceModel> getUserByEmail(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);
        return toUserServiceModel(user);
    }

    @Override
    public void registerUser(UserServiceModel userModel) {
        User user = this.mapper.map(userModel, User.class);
        this.userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        return this.userRepository
                .findById(this.currentUser.getId())
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("There is no user with [%d]", this.currentUser.getId())
                ));
    }

    private Optional<UserServiceModel> toUserServiceModel(Optional<User> user) {
        return user.map(value -> this.mapper.map(value, UserServiceModel.class));
    }
}
