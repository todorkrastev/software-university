package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PostDetailsDto;
import softuni.exam.instagraphlite.models.dtos.UserListDto;
import softuni.exam.instagraphlite.models.dtos.UserSeedDto;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.FileService;
import softuni.exam.instagraphlite.util.MessageService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    public static final String USERS_FILE_PATH = "src/main/resources/files/users.json";
    private final UserRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository repository,
                           FileService fileService,
                           ValidationUtil validator,
                           MessageService messageService,
                           ModelMapper mapper,
                           PictureService pictureService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.fileService.readString(USERS_FILE_PATH);
    }

    @Override
    public String importUsers() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(USERS_FILE_PATH, UserSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(UserSeedDto user) {
        Optional<Picture> profilePicture = pictureService.getPictureByPath(user.getProfilePicture());
        boolean isValid = this.validator.isValid(user, this::isUnique) && profilePicture.isPresent();
        String message = this.messageService.getMessage(user, isValid);

        if (isValid) {
            User dbUser = this.mapper.map(user, User.class);
            dbUser.setProfilePicture(profilePicture.get());
            this.repository.save(dbUser);
        }

        return message;
    }

    private boolean isUnique(UserSeedDto user) {
        return !repository.existsByUsername(user.getUsername());
    }

    @Override
    public String exportUsersWithTheirPosts() {
        return repository.getUserWithPosts().stream()
                .map(u -> {
                    UserListDto userListDto = new UserListDto(u.getUsername());
                    u.getPosts()
                            .forEach(p -> userListDto.getPosts()
                                    .add(new PostDetailsDto(p.getCaption(), p.getPicture().getSize())));
                    return userListDto;
                })
                .map(UserListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return repository.findOneByUsername(username);
    }
}
