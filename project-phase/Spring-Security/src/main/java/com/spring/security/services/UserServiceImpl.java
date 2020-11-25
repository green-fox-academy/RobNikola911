package com.spring.security.services;

import com.spring.security.DTOs.RegisterRequestDto;
import com.spring.security.models.User;
import com.spring.security.repositories.UserRepository;

public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean registerUser(RegisterRequestDto registerRequestDto){
        User user = new User(registerRequestDto);

        Boolean existsUser = userRepository.existsByUsername(user.getUsername());
        try {
            if (!existsUser &&)
        }
    }
}
