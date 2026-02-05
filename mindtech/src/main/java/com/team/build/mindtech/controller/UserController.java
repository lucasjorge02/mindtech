package com.team.build.mindtech.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//essa anotação garante que os spring inicialize a minha controller
@RequestMapping("/user")//contextualizando a rota minha controller
public class UserController {

        @PostMapping//transforma seu metado em um endpoint e garante que os spring inicialize
        public void registerUser() {
        System.out.println("registerUser: ?");
    }

}
