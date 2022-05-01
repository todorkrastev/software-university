package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PostSeedDto;
import softuni.exam.instagraphlite.models.dtos.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.FileService;
import softuni.exam.instagraphlite.util.MessageService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    public static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";
    private final PostRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;
    private final UserService userService;
    private final PictureService pictureService;

    public PostServiceImpl(PostRepository repository,
                           FileService fileService,
                           ValidationUtil validator,
                           MessageService messageService,
                           ModelMapper mapper,
                           UserService userService,
                           PictureService pictureService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.fileService.readString(POSTS_FILE_PATH);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        return this.fileService.readXmlFile(POSTS_FILE_PATH, PostSeedRootDto.class)
                .getPosts()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(PostSeedDto post) {
        Optional<User> user = userService.getUserByUsername(post.getUser().getUsername());
        Optional<Picture> picture = pictureService.getPictureByPath(post.getPicture().getPath());
        boolean isValid = this.validator.isValid(post) && user.isPresent() && picture.isPresent();
        String message = this.messageService.getMessage(post, isValid);
        if (isValid){
            Post dbPost = this.mapper.map(post, Post.class);
            dbPost.setUser(user.get());
            dbPost.setPicture(picture.get());
            this.repository.save(dbPost);
        }
        return message;
    }
}
