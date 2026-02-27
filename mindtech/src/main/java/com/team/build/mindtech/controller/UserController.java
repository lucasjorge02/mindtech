package com.team.build.mindtech.controller;

import com.team.build.mindtech.dto.request.CreateUserRequest;
import com.team.build.mindtech.dto.request.LoginRequest;
import com.team.build.mindtech.entity.User;
import com.team.build.mindtech.service.TokenService;
import com.team.build.mindtech.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid CreateUserRequest request){
        userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }
}
