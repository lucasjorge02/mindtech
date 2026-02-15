package com.team.build.mindtech.service;

import com.team.build.mindtech.model.entity.User;
import com.team.build.mindtech.model.request.CreateUserRequest;
import com.team.build.mindtech.model.response.UserResponse;
import com.team.build.mindtech.repository.UserRepository;
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
