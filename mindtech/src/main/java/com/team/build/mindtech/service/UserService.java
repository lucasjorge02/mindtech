package com.team.build.mindtech.service;

import com.team.build.mindtech.entity.User;
import com.team.build.mindtech.dto.request.CreateUserRequest;
import com.team.build.mindtech.dto.response.UserResponse;
import com.team.build.mindtech.mapper.UserMapper;
import com.team.build.mindtech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse registerUser(CreateUserRequest user) {
        User newUser = userRepository.save(UserMapper.toUser(user));
        return UserMapper.toUserResponse(newUser);
    }
}
