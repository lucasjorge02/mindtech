package com.team.build.mindtech.service;

import com.team.build.mindtech.entity.Usuario;
import com.team.build.mindtech.dto.request.UserRequest;
import com.team.build.mindtech.dto.response.UserResponse;
import com.team.build.mindtech.exception.bussiness.EmailCadastradoException;
import com.team.build.mindtech.mapper.UsuarioMapper;
import com.team.build.mindtech.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsuarioRepository usuarioRepository;
    public UserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UserResponse registerUser(UserRequest user) {
        if (usuarioRepository.existsByEmail(user.email())){
            throw new EmailCadastradoException();
        }

        Usuario usuario = usuarioRepository.save(UsuarioMapper.toUsuario(user));
        return UsuarioMapper.toUserResponse(usuario);
    }
    public List<Usuario> findAllByOrderByNomeAsc() {
        return usuarioRepository.findAllByOrderByNomeAsc();
    }
}