package com.team.build.mindtech.repository;

import com.team.build.mindtech.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
}
