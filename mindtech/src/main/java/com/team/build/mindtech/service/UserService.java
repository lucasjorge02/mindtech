package com.team.build.mindtech.service;

import com.team.build.mindtech.entity.Usuario;
import com.team.build.mindtech.dto.request.UserRequest;
import com.team.build.mindtech.dto.response.UserResponse;
import com.team.build.mindtech.mapper.UsuarioMapper;
import com.team.build.mindtech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UserResponse registerUser(UserRequest user) {
        Usuario usuario = usuarioRepository.save(UsuarioMapper.toUsuario(user));
        return UsuarioMapper.toUserResponse(usuario);
    }
}