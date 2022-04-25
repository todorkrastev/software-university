package com.manhattan.services.productShop.interfaces;

import com.manhattan.models.productsShop.dtos.UserSoldDto;
import com.manhattan.models.productsShop.dtos.UsersAndProductsDto;
import com.manhattan.models.productsShop.entities.User;

import java.util.List;

public interface UserService {
    User getRandomUser();

    void saveAll(Iterable<User> collect);

    List<UserSoldDto> getAllUsersWithMoreThanOneSoldProducts();

    UsersAndProductsDto getAllUsersWithMoreThanOneSoldProductsOrderByProductSoldDescThenByLastName();
}
