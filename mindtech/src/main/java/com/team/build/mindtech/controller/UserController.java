package com.team.build.mindtech.controller;

import com.team.build.mindtech.model.request.UserRequest;
import com.team.build.mindtech.model.response.UserResponse;
import com.team.build.mindtech.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//essa anotação garante que os spring inicialize a minha controller
@RequestMapping("/user")//contextualizando a rota minha controller
public class UserController {
        @Autowired
        private UserService userService;

        @PostMapping//transforma seu metado em um endpoint e garante que os spring inicialize
        public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest) {

                return ResponseEntity.status(HttpStatus.CREATED).body( userService.registerUser(userRequest));

    }

//    @PostMapping("/{name}/{email}/{senha}") // esse usar : "/"
//    public void registerUser(@PathVariable String name,@PathVariable String email,@PathVariable String senha)

//    @PostMapping //esse usar: "?,&"
//    public void registerUser(@RequestParam String name,@RequestParam String email,@RequestParam String senha)
}
