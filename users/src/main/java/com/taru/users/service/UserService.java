package com.taru.users.service;

import com.taru.users.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(String username, UserDTO userDTO);

    boolean deleteUser(String username);

}