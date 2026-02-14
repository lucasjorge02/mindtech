package com.team.build.mindtech.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "nome invalida")@Size(max = 60, message = "Texto deve ter maximo 60 caracteres") String nome,
        @NotBlank(message = "sobrenome invalida")@Size(max = 60, message = "Texto deve ter maximo 60 caracteres") String sobrenome,
        @NotBlank(message = "email invalida") @Size(max = 80, message = "Texto deve ter maximo 80 caracteres")@Email String email,
        @NotBlank(message = "senha invalida")@Size(max = 45, message = "Texto deve ter maximo 45 caracteres") String senha
)  {
}
