package org.softuni.exam.structures;

import org.softuni.exam.entities.User;
import org.softuni.exam.entities.Video;

public class ViTubeRepositoryImpl implements ViTubeRepository {

    @Override
    public void registerUser(User user) {

    }

    @Override
    public void postVideo(Video video) {

    }

    @Override
    public boolean contains(User user) {
        return false;
    }

    @Override
    public boolean contains(Video video) {
        return false;
    }

    @Override
    public Iterable<Video> getVideos() {
        return null;
    }

    @Override
    public void watchVideo(User user, Video video) throws IllegalArgumentException {

    }

    @Override
    public void likeVideo(User user, Video video) throws IllegalArgumentException {

    }

    @Override
    public void dislikeVideo(User user, Video video) throws IllegalArgumentException {

    }

    @Override
    public Iterable<User> getPassiveUsers() {
        return null;
    }

    @Override
    public Iterable<Video> getVideosOrderedByViewsThenByLikesThenByDislikes() {
        return null;
    }

    @Override
    public Iterable<User> getUsersByActivityThenByName() {
        return null;
    }
}
