package com.taru.users.controller;

import com.taru.users.dto.ErrorResponseDTO;
import com.taru.users.dto.ResponseDTO;
import com.taru.users.dto.UpdateUserDTO;
import com.taru.users.dto.UserDTO;
import com.taru.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for User in TaskManager",
        description = "CRUD REST APIs in TaskManager to CREATE, UPDATE, GET AND DELETE users"
)
@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/user", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Create User REST API",
            description = "REST API to create new Users inside TaskManager"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status BAD_REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createUser(@Valid @RequestBody UserDTO userDTO) {

        userService.createUser(userDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO("201", "User created successfully!"));
    }

    @Operation(
            summary = "Get User Details REST API",
            description = "REST API to get user information based on username"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT_FOUND",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username) {

        UserDTO response = userService.getUserByUsername(username);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Operation(
            summary = "Update User Details REST API",
            description = "REST API for updating user information based on username"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT_FOUND",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PutMapping("/{username}/update")
    public ResponseEntity<UserDTO> updateUserByUsername(@Valid @RequestBody UpdateUserDTO userDTO, @PathVariable("username") String username) {

        UserDTO response = userService.updateUserByUsername(username, userDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "REST API for deleting user information based on username"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT_FOUND",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @DeleteMapping("/{username}/delete")
    public ResponseEntity<ResponseDTO> deleteUserByUsername(@PathVariable("username") String username) {

        userService.deleteUserByUsername(username);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO("200", "User deleted successfully!"));
    }
}
