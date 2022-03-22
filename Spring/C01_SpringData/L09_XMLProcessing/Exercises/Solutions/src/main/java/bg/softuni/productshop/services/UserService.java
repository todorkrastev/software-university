package bg.softuni.productshop.services;

import bg.softuni.productshop.models.dtos.UserSeedDto;
import bg.softuni.productshop.models.dtos.UserViewRootDto;
import bg.softuni.productshop.models.entities.User;

import java.util.List;

public interface UserService {
    long getEntityCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findAllUsersWithMoreThanOneSoldProduct();
}
