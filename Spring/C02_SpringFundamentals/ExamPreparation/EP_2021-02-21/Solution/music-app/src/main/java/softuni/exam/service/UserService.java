package softuni.exam.service;

import softuni.exam.model.entity.User;
import softuni.exam.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    boolean loginUser(UserServiceModel userServiceModel);


    User findById(Long id);
}
