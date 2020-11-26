package com.spring.security.models;

import com.spring.security.DTOs.RegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User(RegisterRequestDto registerRequestDto) {
        this.username = registerRequestDto.getUsername();
        this.password = registerRequestDto.getPassword();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
