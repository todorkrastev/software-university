package com.example.exam.service;

import com.example.exam.model.service.PostServiceModel;
import com.example.exam.model.view.CurrentUserPostView;
import com.example.exam.model.view.OtherUserPostView;

import java.util.List;

public interface PostService {
    void addPost(PostServiceModel postModel);

    List<CurrentUserPostView> findAllByIdAndUsernameAndMoodAndLikesAndContent();

    void deleteById(Long id);

    List<OtherUserPostView> findAllOtherUsersPosts();

    void addLikeById(Long id);
}
