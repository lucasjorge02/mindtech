package com.team.build.mindtech.service;

import com.team.build.mindtech.dto.request.LoginRequest;
import com.team.build.mindtech.dto.response.LoginResponse;
import com.team.build.mindtech.entity.Usuario;
import com.team.build.mindtech.exception.bussiness.InvalidCredentialsException;
import com.team.build.mindtech.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UsuarioRepository usuarioRepository;
    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.email());
        if (usuario == null || !usuario.getSenha().equals(loginRequest.senha())) {
            throw  new InvalidCredentialsException("Credenciais errados");
        }
       return new LoginResponse(true);
    }

}
