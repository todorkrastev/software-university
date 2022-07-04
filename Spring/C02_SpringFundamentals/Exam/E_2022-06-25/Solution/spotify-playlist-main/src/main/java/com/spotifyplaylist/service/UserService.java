package com.spotifyplaylist.service;

import com.spotifyplaylist.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    void save(User user);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    @Transactional
    void addSongToUser(Long userId, Long songId);

    @Transactional
    void removeSongFromUser(Long userId, Long songId);

    @Transactional
    void deleteAllSongs(Long userId);
}
