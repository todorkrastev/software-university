package com.spotifyplaylist.service.impl;

import com.spotifyplaylist.model.entity.Song;
import com.spotifyplaylist.model.entity.User;
import com.spotifyplaylist.repo.UserRepo;
import com.spotifyplaylist.service.SongService;
import com.spotifyplaylist.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo repo;
    private final SongService songService;

    public UserServiceImpl(UserRepo repo, SongService songService) {
        this.repo = repo;
        this.songService = songService;
    }

    @Override
    public void save(User user) {
        this.repo.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.repo.findByUsername(username).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    @Override
    public void addSongToUser(Long songId, Long userId) {
        Song song = this.getSongById(songId);
        User user = this.getUserById(userId);
        if (user.addSongToPlaylist(song)) {
            this.repo.save(user);
        }
    }

    @Override
    public void removeSongFromUser(Long songId, Long userId) {
        Song song = this.getSongById(songId);
        User user = this.getUserById(userId);
        if (user.removeSongFromPlaylist(song)) {
            this.repo.save(user);
        }
    }

    @Override
    public void deleteAllSongs(Long userId) {
        User user = this.getUserById(userId);
        if (user.deleteAllSongFromPlaylist()) {
            this.repo.saveAndFlush(user);
        }
    }

    private User getUserById(Long userId) {
        return this.repo.findById(userId).orElseThrow();
    }

    private Song getSongById(Long songId) {
        return this.songService.getSongById(songId);
    }
}
