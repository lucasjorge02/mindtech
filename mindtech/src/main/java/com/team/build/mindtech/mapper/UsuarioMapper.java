package com.team.build.mindtech.mapper;

import com.team.build.mindtech.dto.request.UserRequest;
import com.team.build.mindtech.dto.response.UserResponse;
import com.team.build.mindtech.entity.Usuario;

public final class UsuarioMapper {

    private UsuarioMapper() {
    }
    public static UserResponse toUserResponse(Usuario usuario) {
        return new UserResponse(usuario.getId(), usuario.getNome(), usuario.getSobrenome(),  usuario.getEmail(), usuario.getSenha());

    }
    public static Usuario toUsuario (UserRequest usuario) {
        return new Usuario(usuario.nome(), usuario.sobrenome(), usuario.email(), usuario.senha());
    }
}
