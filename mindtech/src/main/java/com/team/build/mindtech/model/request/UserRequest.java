package com.team.build.mindtech.model.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "nome invalida") String nome,
        @NotBlank(message = "sobrenome invalida") String sobrenome,
        @NotBlank(message = "email invalida") String email,
        @NotBlank(message = "senha invalida") String senha
)  {
}
