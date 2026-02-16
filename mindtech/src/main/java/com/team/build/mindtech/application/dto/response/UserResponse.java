package com.team.build.mindtech.application.dto.response;

public record UserResponse(
        Integer id,
        String name,
        String surname,
        String email,
        String password
) {}