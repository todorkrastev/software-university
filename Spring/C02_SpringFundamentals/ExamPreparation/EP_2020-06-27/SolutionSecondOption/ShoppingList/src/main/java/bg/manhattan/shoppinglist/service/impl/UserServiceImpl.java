package bg.manhattan.shoppinglist.service.impl;

import bg.manhattan.shoppinglist.model.entity.User;
import bg.manhattan.shoppinglist.model.service.UserServiceLoginModel;
import bg.manhattan.shoppinglist.model.service.UserServiceModel;
import bg.manhattan.shoppinglist.repository.UserRepository;
import bg.manhattan.shoppinglist.security.CurrentUser;
import bg.manhattan.shoppinglist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    private final CurrentUser currentUser;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper mapper, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserServiceModel userModel) {
        User user = this.mapper.map(userModel, User.class);
        this.userRepository.save(user);
    }

    @Override
    public boolean loginUser(UserServiceLoginModel userModel) {
        Optional<User> user = this.userRepository.findByUsername(userModel.getUsername());
        if (user.isEmpty()) {
            return false;
        }

        boolean matches = this.passwordEncoder.matches(userModel.getPassword(), user.get().getPasswordHash());
        if (!matches) {
            return false;
        }

        this.currentUser
                .setUsername(user.get().getUsername());

        return true;
    }

    @Override
    public void logout() {
        this.currentUser.clear();
    }

    @Override
    public boolean isLoggedIn() {
        return currentUser.isLoggedIn();
    }
}
