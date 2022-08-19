package com.example.exam.model.view;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {

    private List<CurrentUserPostView> currUserPosts;
    private String currUserUsername;
    List<OtherUserPostView> otherPosts;

    public HomeViewModel() {
        this.currUserPosts = new ArrayList<>();
        this.otherPosts = new ArrayList<>();
    }

    public List<CurrentUserPostView> getCurrUserPosts() {
        return currUserPosts;
    }

    public void setCurrUserPosts(List<CurrentUserPostView> currUserPosts) {
        this.currUserPosts = currUserPosts;
    }

    public String getCurrUserUsername() {
        return currUserUsername;
    }

    public void setCurrUserUsername(String currUserUsername) {
        this.currUserUsername = currUserUsername;
    }

    public List<OtherUserPostView> getOtherPosts() {
        return otherPosts;
    }

    public void setOtherPosts(List<OtherUserPostView> otherPosts) {
        this.otherPosts = otherPosts;
    }
}
