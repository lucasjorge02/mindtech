package com.team.build.mindtech.repository;

import com.team.build.mindtech.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    UserDetails findByEmail(String email);
    List<Usuario> findAllByOrderByNomeAsc();
}
