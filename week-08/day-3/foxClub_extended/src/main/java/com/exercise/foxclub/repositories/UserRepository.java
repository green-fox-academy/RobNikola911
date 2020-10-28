package com.exercise.foxclub.repositories;

import com.exercise.foxclub.models.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String userName);
}