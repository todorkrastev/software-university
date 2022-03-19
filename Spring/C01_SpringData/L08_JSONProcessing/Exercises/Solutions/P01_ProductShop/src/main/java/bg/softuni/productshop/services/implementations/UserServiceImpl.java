package bg.softuni.productshop.services.implementations;

import bg.softuni.productshop.constants.GlobalConstant;
import bg.softuni.productshop.models.dtos.UserAndSoldProductsDto;
import bg.softuni.productshop.models.dtos.UserSeedDto;
import bg.softuni.productshop.models.dtos.UserSoldDto;
import bg.softuni.productshop.models.dtos.UsersAndProductsDto;
import bg.softuni.productshop.models.entities.User;
import bg.softuni.productshop.repositories.UserRepository;
import bg.softuni.productshop.services.UserService;
import bg.softuni.productshop.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    public static final String USERS_FILE_NAME = "users.json";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() == 0) {
            String fileContent = Files.readString(Path.of(GlobalConstant.RESOURCES_FILE_PATH + USERS_FILE_NAME));

            UserSeedDto[] userSeedDtos = this.gson
                    .fromJson(fileContent, UserSeedDto[].class);

            Arrays.stream(userSeedDtos)
                    .filter(this.validationUtil::isValid)
                    .map(userSeedDto -> this.modelMapper.map(userSeedDto, User.class))
                    .forEach(this.userRepository::save);
        }
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, this.userRepository.count() + 1);

        return this.userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProduct() {
        return this.userRepository
                .findAllUsersWithMoreThanOneSoldProductOrderByLastNameAndFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsersAndProductsDto getAllUsersWithMoreThanOneSoldProductOrderByNumberOfSoldProductsDescThenByLastName() {
        List<UserAndSoldProductsDto> userAndSoldProductsDtos = this.userRepository
                .findAllUsersWithMoreThanOneSoldProductOrderBySoldProductsDescLastNameAsc()
                .stream()
                .map(user -> this.modelMapper.map(user, UserAndSoldProductsDto.class))
                .collect(Collectors.toList());

        return new UsersAndProductsDto(userAndSoldProductsDtos);
    }
}
