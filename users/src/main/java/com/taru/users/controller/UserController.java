package com.taru.users.controller;

import com.taru.users.dto.ResponseDto;
import com.taru.users.dto.UpdateUserDTO;
import com.taru.users.dto.UserDTO;
import com.taru.users.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/user", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UserDTO userDTO) {

        userService.createUser(userDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "User created successfully!"));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username) {

        UserDTO response = userService.getUserByUsername(username);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/{username}/update")
    public ResponseEntity<UserDTO> updateUserByUsername(@Valid @RequestBody UpdateUserDTO userDTO, @PathVariable("username") String username) {

        UserDTO response = userService.updateUserByUsername(username, userDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{username}/delete")
    public ResponseEntity<ResponseDto> deleteUserByUsername(@PathVariable("username") String username) {

        userService.deleteUserByUsername(username);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("200", "User deleted successfully!"));
    }
}
