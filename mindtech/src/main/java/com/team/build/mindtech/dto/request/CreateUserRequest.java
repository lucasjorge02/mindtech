package com.team.build.mindtech.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "O Campo 'name' não pode ser vazio ou nulo!")
        @Size(max = 60, message = "O Campo 'name' deve ter ate 60 caracteres")
        String name,

        @NotBlank(message = "O Campo 'surname' não pode ser vazio ou nulo!")
        @Size(max = 60, message = "O Campo 'surname' deve ter ate 60 caracteres")
        String surname,

        @NotBlank(message = "O Campo 'email' não pode ser vazio ou nulo!")
        @Size(max = 80, message = "O Campo 'email' deve ter ate 80 caracteres")
        @Email
        String email,

        @NotBlank(message = "O Campo 'password' não pode ser vazio ou nulo!")
        @Size(min = 8, max = 50, message = "O Campo 'password' deve ter entre 8 à 50 caracteres")
        String password
) {}