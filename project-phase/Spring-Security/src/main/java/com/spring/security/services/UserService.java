package com.spring.security.services;

import com.spring.security.DTOs.RegisterRequestDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> registerUser(RegisterRequestDto registerRequestDto);
}
