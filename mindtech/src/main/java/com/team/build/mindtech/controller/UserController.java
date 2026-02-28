package com.team.build.mindtech.controller;

import com.team.build.mindtech.dto.request.LoginRequest;
import com.team.build.mindtech.dto.request.UserRequest;
import com.team.build.mindtech.dto.response.LoginResponse;
import com.team.build.mindtech.dto.response.UserResponse;
import com.team.build.mindtech.service.LoginService;
import com.team.build.mindtech.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//essa anotação garante que os spring inicialize a minha controller
@RequestMapping("/user")//contextualizando a rota minha controller
public class UserController {

        private final UserService userService;
        private final LoginService loginService;

        public UserController(UserService userService, LoginService loginService) {
            this.userService = userService;
            this.loginService = loginService;
        }

        @PostMapping("/register")//transforma seu metado em um endpoint e garante que os spring inicialize
        public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest) {
                return ResponseEntity.status(HttpStatus.CREATED).body( userService.registerUser(userRequest));
        }

        @PostMapping("/login")
        public ResponseEntity<LoginResponse> loginUser(@RequestBody @Valid LoginRequest loginRequest) {
                LoginResponse login = loginService.login(loginRequest);
                return ResponseEntity.ok(login);
        }
        //    @PostMapping("/{name}/{email}/{senha}") // esse usar : "/"
//    public void registerUser(@PathVariable String name,@PathVariable String email,@PathVariable String senha)

//    @PostMapping //esse usar: "?,&"
//    public void registerUser(@RequestParam String name,@RequestParam String email,@RequestParam String senha)
}
