package com.team.build.mindtech.service;

import com.team.build.mindtech.model.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public ResponseEntity registerUser(UserRequest user) {
//        if (user.nome() == null){
//            return ResponseEntity.badRequest().body("Por favor verifique seu nome: " + user.nome());
//        } if (user.email() == null) {
//            return ResponseEntity.badRequest().body("Por favor verifique seu email: " + user.email());
//        }if (user.senha() == null) {
//            return ResponseEntity.badRequest().body("Por favor verifique seus senha: " + user.senha());
//        }if (user.sobrenome() == null) {
//            return ResponseEntity.badRequest().body("Por favor verifique seus sobrenome: " + user.sobrenome());
//        }
        return ResponseEntity.ok().build();
    }
}
