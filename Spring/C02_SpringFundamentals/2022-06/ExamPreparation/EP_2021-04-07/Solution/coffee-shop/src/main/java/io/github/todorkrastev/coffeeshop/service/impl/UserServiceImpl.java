package io.github.todorkrastev.coffeeshop.service.impl;

import io.github.todorkrastev.coffeeshop.model.entity.User;
import io.github.todorkrastev.coffeeshop.model.service.UserServiceModel;
import io.github.todorkrastev.coffeeshop.model.view.UserViewModel;
import io.github.todorkrastev.coffeeshop.repository.UserRepository;
import io.github.todorkrastev.coffeeshop.service.UserService;
import io.github.todorkrastev.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return this.userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        this.currentUser.setId(id);
        this.currentUser.setUsername(username);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUsersByCountOfOrdersOrderedByCountDesc() {
        return this.userRepository
                .findAllByOrdersCountDesc()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCountOfOrders(user.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
