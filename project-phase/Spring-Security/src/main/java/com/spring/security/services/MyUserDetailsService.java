package com.spring.security.services;

import com.spring.security.configuration.JwtUtil;
import com.spring.security.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;
    private JwtUtil JwtUtils;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.spring.security.models.User user = repository.findByUsername(username);
        //CHANGE TO ACTUAL USER-CLASS FIELDS LATER
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    @Transactional
    public String authenticate(final String username, final String password) {
        final Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return JwtUtils.generateToken(this.loadUserByUsername(username));
    }
}
