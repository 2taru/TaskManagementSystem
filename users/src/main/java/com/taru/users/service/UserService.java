package com.taru.users.service;

import com.taru.users.dto.UserDTO;

public interface UserService {

    void createUser(UserDTO userDTO);

    UserDTO getUserByUsername(String username);

    UserDTO updateUserByUsername(String username, UserDTO userDTO);

    void deleteUserByUsername(String username);

}