package com.team.build.mindtech.dto.response;

public record UserResponse(
        Integer id,
        String name,
        String surname,
        String email
) {}