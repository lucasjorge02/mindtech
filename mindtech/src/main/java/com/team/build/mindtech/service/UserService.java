package com.team.build.mindtech.service;

import com.team.build.mindtech.dto.request.LoginRequest;
import com.team.build.mindtech.dto.response.TokenResponse;
import com.team.build.mindtech.entity.User;
import com.team.build.mindtech.dto.request.CreateUserRequest;
import com.team.build.mindtech.mapper.UserMapper;
import com.team.build.mindtech.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(AuthenticationManager manager, TokenService tokenService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.manager = manager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(CreateUserRequest user) {
        User newUser = UserMapper.toUser(user);
        System.out.println(passwordEncoder.getClass());
        newUser.setPassword(passwordEncoder.encode(user.password()));
        userRepository.save(newUser);
    }

    public TokenResponse login(LoginRequest request) {
       UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.email(), request.password());
       Authentication authentication = manager.authenticate(authenticationToken);
       String token = tokenService.generateToken((User) authentication.getPrincipal());
       return new TokenResponse(token);
    }
}