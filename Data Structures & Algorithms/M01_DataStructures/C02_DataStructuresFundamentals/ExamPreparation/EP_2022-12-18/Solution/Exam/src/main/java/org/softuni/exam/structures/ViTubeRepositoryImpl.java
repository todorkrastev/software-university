package org.softuni.exam.structures;

import org.softuni.exam.entities.User;
import org.softuni.exam.entities.Video;

import java.util.*;

public class ViTubeRepositoryImpl implements ViTubeRepository {
    private Map<String, User> users;
    private Map<String, Video> videos;
    private Map<String, Set<String>> userWatchedVideos;
    private Map<String, Set<String>> userLikedVideos;
    private Map<String, Set<String>> userDislikedVideos;

    public ViTubeRepositoryImpl() {
        this.users = new HashMap<>();
        this.videos = new HashMap<>();
        this.userWatchedVideos = new HashMap<>();
        this.userLikedVideos = new HashMap<>();
        this.userDislikedVideos = new HashMap<>();
    }

    @Override
    public void registerUser(User user) {
        this.users.put(user.getId(), user);
    }

    @Override
    public void postVideo(Video video) {
        this.videos.put(video.getId(), video);
    }

    @Override
    public boolean contains(User user) {
        return this.users.containsKey(user.getId());
    }

    @Override
    public boolean contains(Video video) {
        return this.videos.containsKey(video.getId());
    }

    @Override
    public Iterable<Video> getVideos() {
        return this.videos.values();
    }

    @Override
    public void watchVideo(User user, Video video) throws IllegalArgumentException {
        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }
        video.setViews(video.getViews() + 1);
        this.userWatchedVideos.computeIfAbsent(user.getId(), k -> new HashSet<>()).add(video.getId());
    }

    @Override
    public void likeVideo(User user, Video video) throws IllegalArgumentException {
        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }
        video.setLikes(video.getLikes() + 1);
        this.userLikedVideos.computeIfAbsent(user.getId(), k -> new HashSet<>()).add(video.getId());
    }

    @Override
    public void dislikeVideo(User user, Video video) throws IllegalArgumentException {
        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }
        video.setDislikes(video.getDislikes() + 1);
        this.userDislikedVideos.computeIfAbsent(user.getId(), k -> new HashSet<>()).add(video.getId());
    }

    @Override
    public Iterable<User> getPassiveUsers() {
        List<User> passiveUsers = new ArrayList<>();
        for (User user : this.users.values()) {
            if (!this.userWatchedVideos.containsKey(user.getId()) &&
                    !this.userLikedVideos.containsKey(user.getId()) &&
                    !this.userDislikedVideos.containsKey(user.getId())) {
                passiveUsers.add(user);
            }
        }
        return passiveUsers;
    }

    @Override
    public Iterable<Video> getVideosOrderedByViewsThenByLikesThenByDislikes() {
        List<Video> sortedVideos = new ArrayList<>(this.videos.values());
        sortedVideos.sort(Comparator.comparing(Video::getViews).reversed()
                .thenComparing(Video::getLikes, Comparator.reverseOrder())
                .thenComparing(Video::getDislikes));
        return sortedVideos;
    }

    @Override
    public Iterable<User> getUsersByActivityThenByName() {
        List<User> sortedUsers = new ArrayList<>(this.users.values());
        sortedUsers.sort(Comparator.comparing((User user) -> this.userWatchedVideos.getOrDefault(user.getId(), Collections.emptySet()).size()).reversed()
                .thenComparing((User user) -> this.userLikedVideos.getOrDefault(user.getId(), Collections.emptySet()).size() + this.userDislikedVideos.getOrDefault(user.getId(), Collections.emptySet()).size(), Comparator.reverseOrder())
                .thenComparing(User::getUsername));
        return sortedUsers;
    }
}