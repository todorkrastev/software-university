package bg.manhattan.coffeeshop.service;

import bg.manhattan.coffeeshop.model.entity.User;
import bg.manhattan.coffeeshop.model.service.UserServiceLoginModel;
import bg.manhattan.coffeeshop.model.service.UserServiceModel;
import bg.manhattan.coffeeshop.model.view.UserOrdersViewModel;

import java.util.List;

public interface UserService {



    UserServiceModel registerUser(UserServiceModel user);

    boolean login(UserServiceLoginModel user);

    void logout();

    User getUserById(Long Id);

    List<UserOrdersViewModel> getOrdersUsersWithTheirOrdersCountOrderByCountDesc();
}
