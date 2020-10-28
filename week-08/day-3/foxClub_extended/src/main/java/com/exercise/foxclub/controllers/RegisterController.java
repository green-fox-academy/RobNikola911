package com.exercise.foxclub.controllers;

import com.exercise.foxclub.models.character.Fox;
import com.exercise.foxclub.models.user.User;
import com.exercise.foxclub.services.Logger;
import com.exercise.foxclub.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private final UserService userService;
    private Logger logger;

    public RegisterController(UserService userService, Logger logger) {
        this.userService = userService;
        this.logger = logger;
    }

    @GetMapping("/register")
    public String renderRegistrationForm(Model model) {
        return "register/form";
    }

    @PostMapping("/register")
    public String createUser(Model model, User user) {
        userService.createUser(user.getUsername(), user.getPassword(), user.getEmail());
        model.addAttribute("fox", new Fox());
        model.addAttribute("user", userService.getLoggedInUser());
        model.addAttribute("actionHistoryLogger", logger);
        logger.saveLoginAction();
        return "redirect:/fox/create";
    }
}