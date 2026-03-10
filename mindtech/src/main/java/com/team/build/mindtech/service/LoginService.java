package com.team.build.mindtech.service;

import com.team.build.mindtech.dto.request.LoginRequest;
import com.team.build.mindtech.dto.response.TokenResponse;
import com.team.build.mindtech.entity.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService  {
    private final AutenticacaoService autenticacaoService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    public LoginService (AutenticacaoService autenticacaoService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.autenticacaoService = autenticacaoService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public TokenResponse login(LoginRequest loginRequest) {
        //autenticacaoService.loadUserByUsername(loginRequest.email());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return new TokenResponse(token);
    }


}
