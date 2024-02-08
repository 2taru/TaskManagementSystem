package com.taru.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(
        name = "UserUpdate",
        description = "A schema for storing user information for updates"
)
public class UpdateUserDTO {

    @Schema(
            description = "User's email address", example = "john.doe@mail.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;
}
