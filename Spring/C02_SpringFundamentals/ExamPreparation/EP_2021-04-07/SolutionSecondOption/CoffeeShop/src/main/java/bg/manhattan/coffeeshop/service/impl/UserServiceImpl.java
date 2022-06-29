package bg.manhattan.coffeeshop.service.impl;

import bg.manhattan.coffeeshop.model.view.UserOrdersViewModel;
import bg.manhattan.coffeeshop.security.CurrentUser;
import bg.manhattan.coffeeshop.model.entity.User;
import bg.manhattan.coffeeshop.model.service.UserServiceLoginModel;
import bg.manhattan.coffeeshop.model.service.UserServiceModel;
import bg.manhattan.coffeeshop.repository.UserRepository;
import bg.manhattan.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository repository;
    private final ModelMapper mapper;
    private final CurrentUser currentUser;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, ModelMapper mapper, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel user) {
        User dbUser = mapper.map(user, User.class);
        this.repository.save(dbUser);
        LOGGER.info("Created user [{}] successful!", dbUser.getUsername());
        return mapper.map(dbUser, UserServiceModel.class);
    }

    @Override
    public boolean login(UserServiceLoginModel user) {
        Optional<User> dbUser = this.repository.findByUsername(user.getUsername());
        if (dbUser.isEmpty()) return false;
        boolean passwordMatches = this.passwordEncoder.matches(user.getPassword(), dbUser.get().getPassword());
        if (passwordMatches){
            this.mapper.map(dbUser, this.currentUser);
            this.currentUser
                    .setId(dbUser.get().getId())
                    .setUsername(dbUser.get().getUsername())
                    .setLoggedIn(true);
        }

        return passwordMatches;
    }

    @Override
    public void logout() {
        this.currentUser.clear();
    }

    @Override
    public User getUserById(Long id) {
        return this.repository.findById(id)
                .orElse(null);
    }

    @Override
    public List<UserOrdersViewModel> getOrdersUsersWithTheirOrdersCountOrderByCountDesc() {
        return this.repository.findOrdersUsersWithTheirOrdersCountOrderByCountDesc();
    }
}
