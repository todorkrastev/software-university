package com.spotifyplaylist.model.mapper;

import com.spotifyplaylist.model.dto.RegisterDTO;
import com.spotifyplaylist.model.dto.UserDTO;
import com.spotifyplaylist.model.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);

    User toUser(RegisterDTO registerDTO);
}
