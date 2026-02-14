package com.team.build.mindtech.service;

import com.team.build.mindtech.model.entity.Usuario;
import com.team.build.mindtech.model.request.UserRequest;
import com.team.build.mindtech.model.response.UserResponse;
import com.team.build.mindtech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UserResponse registerUser(UserRequest user) {
        Usuario usuario = usuarioRepository.save(new Usuario(user.nome(), user.sobrenome(), user.email(), user.senha()));

        return new UserResponse(usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getSenha());

    }
}
