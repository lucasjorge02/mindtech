package com.team.build.mindtech.repository;

import com.team.build.mindtech.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends CrudRepository<User, Integer> {

    UserDetails findByEmail(String email);
}
