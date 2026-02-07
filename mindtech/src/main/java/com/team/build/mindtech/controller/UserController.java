package com.team.build.mindtech.controller;

import com.team.build.mindtech.model.request.CreateUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public void registerUser(@RequestBody CreateUserRequest request){
        System.out.println("Registrando usuario: " + request);
    }
}
