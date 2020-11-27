package com.spring.security.services;

import com.spring.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.spring.security.models.User user = repository.findByUsername(username);
        //CHANGE TO ACTUAL USER-CLASS FIELDS LATER
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
