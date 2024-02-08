package com.taru.users.service.impl;

import com.taru.users.dto.UpdateUserDTO;
import com.taru.users.dto.UserDTO;
import com.taru.users.entity.UserEntity;
import com.taru.users.exception.ResourceNotFoundException;
import com.taru.users.exception.UserAlreadyExistsException;
import com.taru.users.mapper.UserMapper;
import com.taru.users.repository.UserRepository;
import com.taru.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserDTO userDTO) {

        UserEntity user = UserMapper.mapToEntity(userDTO);
        Optional<UserEntity> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User already registered with given username: "
                    + user.getUsername());
        }

        userRepository.save(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User", "username", username)
        );

        return UserMapper.mapToDto(user);
    }

    @Override
    public UserDTO updateUserByUsername(String username, UpdateUserDTO userDTO) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User", "username", username)
        );

        user.setEmail(userDTO.getEmail());

        UserEntity updatedUser = userRepository.save(user);
        return UserMapper.mapToDto(updatedUser);
    }

    @Override
    public void deleteUserByUsername(String username) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User", "username", username)
        );

        userRepository.deleteById(user.getUserId());
    }
}
