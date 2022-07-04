package com.spotifyplaylist.service;

import com.spotifyplaylist.model.dto.RegisterDTO;
import com.spotifyplaylist.model.dto.UserDTO;

public interface AuthService {

     void login(String username);

     void register(RegisterDTO registerDTO);

     void logout();

     boolean checkCredentials(String username, String password);

     UserDTO findUserByUsername(String username);

     UserDTO findUserByEmail(String email);
}
