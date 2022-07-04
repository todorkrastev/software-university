package com.spotifyplaylist.service.impl;

import com.spotifyplaylist.model.dto.UserDTO;
import com.spotifyplaylist.model.mapper.UserMapper;
import com.spotifyplaylist.service.AuthService;
import com.spotifyplaylist.service.UserService;
import com.spotifyplaylist.session.LoggedUser;
import com.spotifyplaylist.model.dto.RegisterDTO;
import com.spotifyplaylist.model.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final LoggedUser loggedUser;
    private final HttpSession session;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserService userService, PasswordEncoder encoder,
                           LoggedUser loggedUser, HttpSession session, UserMapper userMapper) {
        this.userService = userService;
        this.encoder = encoder;
        this.loggedUser = loggedUser;
        this.session = session;
        this.userMapper = userMapper;
    }

    @Override
    public void login(String username) {
        User user = this.userService.getUserByUsername(username);
        this.loggedUser
                .setId(user.getId())
                .setUsername(user.getUsername());
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        User user = this.userMapper.toUser(registerDTO);
        user.setPassword(this.encoder.encode(user.getPassword()));
        this.userService.save(user);
        this.login(registerDTO.getUsername());
    }

    @Override
    public void logout() {
        this.session.invalidate();
        this.loggedUser.invalidate();
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        User user = this.userService.getUserByUsername(username);
        if (user == null) {
            return false;
        }

        return encoder.matches(password, user.getPassword());
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        User user = this.userService.getUserByUsername(username);
        return this.userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userService.getUserByEmail(email);
        return this.userMapper.toUserDTO(user);
    }

    /*
    private User mapUser(RegisterDTO registerDTO) {
        return new User()
                .setUsername(registerDTO.getUsername())
                .setEmail(registerDTO.getEmail())
                .setPassword(encoder.encode(registerDTO.getPassword()));
    }

    private UserDTO mapUserDTO(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setUsername(user.getUsername());

    }
     */
}
