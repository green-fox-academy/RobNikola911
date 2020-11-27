package com.spring.security.services;

import com.spring.security.DTOs.RegisterRequestDto;
import com.spring.security.models.User;
import com.spring.security.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ResponseEntity<Object> registerUser(RegisterRequestDto registerRequestDto) {

        Boolean existsUser = userRepository.existsByUsername(registerRequestDto.getUsername());
        if (!existsUser
                && !registerRequestDto.getUsername().isEmpty()
                && registerRequestDto.getUsername() != null
                && !registerRequestDto.getPassword().isEmpty()
                && registerRequestDto.getPassword() != null) {
            User user = new User(registerRequestDto);
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>("Username is taken or invalid or invalid password", HttpStatus.CONFLICT);
    }
}

