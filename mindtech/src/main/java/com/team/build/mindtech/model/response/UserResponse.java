package com.team.build.mindtech.model.response;

public record UserResponse(
        Integer id,
        String name,
        String surname,
        String email,
        String password
) {}