package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.model.entity.User;
import softuni.exam.model.service.UserServiceModel;
import softuni.exam.repository.UserRepository;
import softuni.exam.service.UserService;
import softuni.exam.util.CurrentUser;

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
    public boolean registerUser(UserServiceModel userServiceModel) {

        if (userRepository.existsByUsername(userServiceModel.getUsername())) {
            return false;
        }

        User newUser = modelMapper.map(userServiceModel, User.class);
        userRepository.save(newUser);
        return true;
    }

    @Override
    public boolean loginUser(UserServiceModel userServiceModel) {
        User user = userRepository.findByUsernameAndPassword(userServiceModel.getUsername(), userServiceModel.getPassword());

        if (user == null) {
            return false;
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setId(user.getId());
        return true;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
