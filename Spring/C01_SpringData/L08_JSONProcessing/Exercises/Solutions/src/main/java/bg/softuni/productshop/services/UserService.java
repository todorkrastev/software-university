package bg.softuni.productshop.services;

import bg.softuni.productshop.models.dtos.UserSoldDto;
import bg.softuni.productshop.models.dtos.UsersAndProductsDto;
import bg.softuni.productshop.models.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProduct();

    UsersAndProductsDto getAllUsersWithMoreThanOneSoldProductOrderByNumberOfSoldProductsDescThenByLastName();
}
