package com.team.build.mindtech.domain.service;

import com.team.build.mindtech.infrastructure.entity.User;
import com.team.build.mindtech.application.dto.request.CreateUserRequest;
import com.team.build.mindtech.application.dto.response.UserResponse;
import com.team.build.mindtech.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse registerUser(CreateUserRequest user) {
        User newUser = userRepository.save(new User(user.name(), user.surname(), user.email(), user.password()));
        return new UserResponse(newUser.getId(), newUser.getName(),  newUser.getSurname(), newUser.getEmail(), newUser.getPassword());
    }
}
