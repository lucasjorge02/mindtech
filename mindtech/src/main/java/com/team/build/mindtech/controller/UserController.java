package com.team.build.mindtech.controller;

import com.team.build.mindtech.model.request.CreateUserRequest;
import com.team.build.mindtech.model.request.UserRequest;
import org.springframework.web.bind.annotation.*;


@RestController//essa anotação garante que os spring inicialize a minha controller
@RequestMapping("/user")//contextualizando a rota minha controller
public class UserController {

        @PostMapping//transforma seu metado em um endpoint e garante que os spring inicialize
        public void registerUser(@RequestBody UserRequest userRequest) {
        System.out.println("registerUser: " + userRequest.nome());
        System.out.println("registerUser: " + userRequest.email());
        System.out.println("registerUser: " + userRequest.senha());
    }

//    @PostMapping("/{name}/{email}/{senha}") // esse usar : "/"
//    public void registerUser(@PathVariable String name,@PathVariable String email,@PathVariable String senha)

//    @PostMapping //esse usar: "?,&"
//    public void registerUser(@RequestParam String name,@RequestParam String email,@RequestParam String senha)
}
