package com.team.build.mindtech.repository;

import com.team.build.mindtech.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
