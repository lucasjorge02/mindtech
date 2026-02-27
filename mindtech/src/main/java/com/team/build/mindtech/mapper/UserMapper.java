package com.team.build.mindtech.mapper;

import com.team.build.mindtech.dto.request.CreateUserRequest;
import com.team.build.mindtech.dto.response.UserResponse;
import com.team.build.mindtech.entity.User;

public final class UserMapper {

    private UserMapper() {}

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getSurname(), user.getEmail());
    }

    public static User toUser(CreateUserRequest user) {
        return new User(user.name(), user.surname(), user.email(), user.password());
    }
}
