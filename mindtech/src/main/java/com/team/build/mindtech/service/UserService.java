package com.team.build.mindtech.service;

import com.team.build.mindtech.entity.Usuario;
import com.team.build.mindtech.dto.request.UserRequest;
import com.team.build.mindtech.dto.response.UserResponse;
import com.team.build.mindtech.exception.bussiness.EmailCadastradoException;
import com.team.build.mindtech.mapper.UsuarioMapper;
import com.team.build.mindtech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UserResponse registerUser(UserRequest user) {
        if (usuarioRepository.existsByEmail(user.email())){
            throw new EmailCadastradoException();

        }
        Usuario usuario = usuarioRepository.save(UsuarioMapper.toUsuario(user));
        return UsuarioMapper.toUserResponse(usuario);
    }
}