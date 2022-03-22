package bg.softuni.productshop.services.implementations;

import bg.softuni.productshop.models.dtos.UserSeedDto;
import bg.softuni.productshop.models.dtos.UserViewRootDto;
import bg.softuni.productshop.models.dtos.UserViewWithProductsDto;
import bg.softuni.productshop.models.entities.User;
import bg.softuni.productshop.repositories.UserRepository;
import bg.softuni.productshop.services.UserService;
import bg.softuni.productshop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getEntityCount() {
        return this.userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        users
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> this.modelMapper.map(userSeedDto, User.class))
                .forEach(this.userRepository::save);
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, this.userRepository.count() + 1);

        return this.userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public UserViewRootDto findAllUsersWithMoreThanOneSoldProduct() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();

        List<UserViewWithProductsDto> userViewWithProductsDtoList = this.userRepository
                .findAllUsersWithMoreThanOneSoldProductOrderByLastNameAndFirstName()
                .stream()
                .map(user -> this.modelMapper.map(user, UserViewWithProductsDto.class))
                .collect(Collectors.toList());

        userViewRootDto.setProducts(userViewWithProductsDtoList);

        return userViewRootDto;
    }
}
