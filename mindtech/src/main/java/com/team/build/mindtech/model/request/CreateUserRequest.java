package com.team.build.mindtech.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
       @NotBlank String name,
       @NotBlank String surname,
       @NotBlank @Email String email,
       @NotBlank String password
) {}