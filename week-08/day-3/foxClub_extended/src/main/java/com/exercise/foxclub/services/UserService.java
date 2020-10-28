package com.exercise.foxclub.services;

import com.exercise.foxclub.models.Validation;
import com.exercise.foxclub.models.user.User;

public interface UserService {
    User getLoggedInUser();
    void logout();
    boolean validateAndLoginUser(User user);
    Validation validateAndLoginUser(User user, Validation validation);
    User createUser(String username, String password, String email);
    void logInUser(User user);

    void updateUsersActiveFoxIndex(int activeFoxIndex);

    User findByUsername(String name);
}