package com.team.build.mindtech.controller;

import com.team.build.mindtech.model.request.CreateUserRequest;
import com.team.build.mindtech.model.response.UserResponse;
import com.team.build.mindtech.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid CreateUserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(request));
    }
}
