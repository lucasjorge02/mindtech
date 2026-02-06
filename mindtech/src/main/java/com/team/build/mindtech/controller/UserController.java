package com.team.build.mindtech.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/user")
public class UserController {
    @PostMapping
    public void registerUser (@RequestParam String name,@RequestParam String surname, @RequestParam String email, @RequestParam String password ) {
        System.out.println("Registrando Usuário: "+name);
        System.out.println("Registrando Sobrenome: "+surname);
        System.out.println("Registrando Email: "+email);
        System.out.println("Registrando Senha: "+password);
    }
}

