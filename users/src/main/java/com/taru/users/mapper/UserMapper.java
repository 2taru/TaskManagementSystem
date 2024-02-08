package com.taru.users.mapper;

import com.taru.users.dto.UserDTO;
import com.taru.users.entity.UserEntity;

public class UserMapper {

    public static UserDTO mapToDto(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public static UserEntity mapToEntity(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
