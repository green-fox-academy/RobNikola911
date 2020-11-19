package com.greenfox.reddit.services;

import com.greenfox.reddit.models.User;
import com.greenfox.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkUser(String name, String password) {
        List<User> listOfUsers = userRepository.findAll();
        //check name + password -> return boolean
        return listOfUsers.stream()
                .anyMatch(userToCheck -> userToCheck.getUsername().equals(name) && userToCheck.getPassword().equals(password));
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
        return optionalUser.orElseThrow();
    }
}
