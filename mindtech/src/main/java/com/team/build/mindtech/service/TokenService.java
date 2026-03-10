package com.team.build.mindtech.service;

import com.team.build.mindtech.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String SECRET_KEY;
    public String gerarToken(Usuario usuario){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.builder()
                .subject(usuario.getEmail())
                .signWith(key)
                .issuer("mindtech")
                .id(usuario.getId().toString())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plus(5, ChronoUnit.MINUTES)))
                .compact();
    }

}
