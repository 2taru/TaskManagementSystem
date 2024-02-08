package com.taru.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "User",
        description = "Scheme for storing user information"
)
public class UserDTO {

    @Schema(
            description = "Username", example = "john-doe34"
    )
    @NotEmpty(message = "Username can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the username should be between 5 and 30")
    private String username;

    @Schema(
            description = "User's email address", example = "john.doe@mail.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;
}
