package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constant.GlobalConstant;
import softuni.exam.instagraphlite.models.dto.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PictureService pictureService;
    private final UserService userService;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, PictureService pictureService, UserService userService, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.pictureService = pictureService;
        this.userService = userService;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        PostSeedRootDto postSeedRootDto = this.xmlParser.fromFile(GlobalConstant.POSTS_FILE_PATH, PostSeedRootDto.class);

        postSeedRootDto
                .getPosts()
                .stream()
                .filter(postSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(postSeedDto) &&
                            this.pictureService.doesEntityExist(postSeedDto.getPicture().getPath()) &&
                            this.userService.doesEntityExist(postSeedDto.getUser().getUsername());


                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Post, made by %s", postSeedDto.getUser().getUsername()) :
                                    "Invalid Post")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(postSeedDto -> {
                    Post post = this.modelMapper.map(postSeedDto, Post.class);

                    String caption = postSeedDto.getCaption();
                    post.setCaption(caption);

                    String path = postSeedDto.getPicture().getPath();
                    Picture picture = this.pictureService.findByPath(path);
                    post.setPicture(picture);

                    String username = postSeedDto.getUser().getUsername();
                    User user = this.userService.findByUsername(username);
                    post.setUser(user);

                    return post;
                })
                .forEach(this.postRepository::save);

        return stringBuilder.toString();
    }
}
