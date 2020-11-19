package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;

import java.util.List;

public interface UserService {

    boolean checkUser(String name, String password);
    void saveUser(User user);
    List<User> findAllUsers();

    User getUser(String username);
}
