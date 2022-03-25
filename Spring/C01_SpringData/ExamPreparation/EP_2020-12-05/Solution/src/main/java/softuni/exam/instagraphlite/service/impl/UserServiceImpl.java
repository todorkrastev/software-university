package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constant.GlobalConstant;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, Gson gson, ValidationUtil validationUtil, PictureService pictureService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        UserSeedDto[] userSeedDtos = this.gson.fromJson(readFromFileContent(), UserSeedDto[].class);

        Arrays
                .stream(userSeedDtos)
                .filter(userSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(userSeedDto) &&
                            !doesEntityExist(userSeedDto.getUsername()) &&
                            this.pictureService.doesEntityExist(userSeedDto.getProfilePicture());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported User: %s", userSeedDto.getUsername()) :
                                    "Invalid User")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(userSeedDto -> {
                    User user = this.modelMapper.map(userSeedDto, User.class);
                    Picture picture = this.pictureService.findByPath(userSeedDto.getProfilePicture());
                    user.setProfilePicture(picture);

                    return user;
                })
                .forEach(this.userRepository::save);

        System.out.println();
        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExist(String username) {
        return this.userRepository.existsByUsername(username);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder stringBuilder = new StringBuilder();

        this.userRepository
                .findAllUsersByPostsOrderByCountOfPostsDescThenByUserIdAsc()
                .forEach(user -> {
                    stringBuilder
                            .append(String.format("""
                                            User: %s
                                            Post count: %d
                                            """,
                                    user.getUsername(),
                                    user.getPosts().size()
                            ));

                    user.getPosts()
                            .stream()
                            .sorted(Comparator.comparingDouble(post -> post.getPicture().getSize()))
                            .forEach(post -> stringBuilder
                                    .append(String.format("""
                                                    ==Post Details:
                                                    ----Caption: %s
                                                    ----Picture Size: %.2f
                                                    """,
                                            post.getCaption(),
                                            post.getPicture().getSize())));
                });

        return stringBuilder.toString();
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository
                .findByUsername(username)
                .orElse(null);
    }
}
