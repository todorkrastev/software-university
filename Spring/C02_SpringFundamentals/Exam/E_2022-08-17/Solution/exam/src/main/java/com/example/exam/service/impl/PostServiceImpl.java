package com.example.exam.service.impl;

import com.example.exam.model.entity.Mood;
import com.example.exam.model.entity.Post;
import com.example.exam.model.entity.User;
import com.example.exam.model.service.PostServiceModel;
import com.example.exam.model.view.CurrentUserPostView;
import com.example.exam.model.view.OtherUserPostView;
import com.example.exam.repository.PostRepository;
import com.example.exam.service.MoodService;
import com.example.exam.service.PostService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final ModelMapper mapper;
    private final PostRepository postRepository;
    private final UserService userService;
    private final MoodService moodService;

    public PostServiceImpl(ModelMapper mapper, PostRepository postRepository, UserService userService, MoodService moodService) {
        this.mapper = mapper;
        this.postRepository = postRepository;
        this.userService = userService;
        this.moodService = moodService;
    }

    @Override
    public void addPost(PostServiceModel postModel) {
        Post post = this.mapper.map(postModel, Post.class);

        User user = this.userService.getCurrentUser();
        post.setUser(user);

        Mood mood = this.moodService.getByName(postModel.getMood());
        post.setMood(mood);

        this.postRepository.save(post);
    }

    @Override
    public List<CurrentUserPostView> findAllByIdAndUsernameAndMoodAndLikesAndContent() {
        return this.postRepository.findAllByIdAndUsernameAndMoodAndLikesAndContent();
    }

    @Override
    public void deleteById(Long id) {
        this.postRepository
                .findById(id).ifPresent(post -> this.postRepository.deleteById(id));
    }

    @Override
    public List<OtherUserPostView> findAllOtherUsersPosts() {
        return this.postRepository.findAllOtherUsersPosts();
    }

    @Override
    public void addLikeById(Long id) {
        Post post = this.postRepository
                .findById(id)
                .orElse(null);

        User user = this.userService.getCurrentUser();

        if (user != null && post != null) {
            Set<User> userLikes = post.getUserLikes();
            userLikes.add(user);

            this.postRepository.save(post);
        }
    }
}
