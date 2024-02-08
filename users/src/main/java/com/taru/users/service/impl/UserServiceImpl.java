package com.taru.users.service.impl;

import com.taru.users.dto.UserDTO;
import com.taru.users.entity.UserEntity;
import com.taru.users.mapper.UserMapper;
import com.taru.users.repository.UserRepository;
import com.taru.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity user = UserMapper.mapToEntity(userDTO);
        Optional<UserEntity> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()){
            throw new RuntimeException("User already registered with given username "
                    + user.getUsername());
        }

        UserEntity savedUser = userRepository.save(user);
        return UserMapper.mapToDto(savedUser);
    }

    @Override
    public UserDTO getUserByUsername(String username) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User with username: " + username + " - not found!")
        );

        return UserMapper.mapToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<UserEntity> users = userRepository.findAll();

        return users.stream()
                .map(UserMapper::mapToDto).toList();
    }

    @Override
    public UserDTO updateUser(String username, UserDTO userDTO) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User with username: " + username + " - not found!")
        );

        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        UserEntity updatedUser = userRepository.save(user);
        return UserMapper.mapToDto(updatedUser);
    }

    @Override
    public boolean deleteUser(String username) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User with username: " + username + " - not found!")
        );

        userRepository.deleteById(user.getUserId());

        return true;
    }
}
