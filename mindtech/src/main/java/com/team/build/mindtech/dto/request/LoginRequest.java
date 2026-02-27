package com.team.build.mindtech.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "E-mail não pode ser vazio!") @Size(max = 80, message = "Email precisa ter no máximo 80 caracteres!") @Email String email,
        @NotBlank(message = "Password não pode ser vazio!") @Size(max = 60, message = "Password precisa ter no máximo 60 caracteres!") String password
) {
}
