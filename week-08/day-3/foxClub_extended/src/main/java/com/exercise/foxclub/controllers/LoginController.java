package com.exercise.foxclub.controllers;

import com.exercise.foxclub.models.Validation;
import com.exercise.foxclub.models.user.User;
import com.exercise.foxclub.services.FoxService;
import com.exercise.foxclub.services.Logger;
import com.exercise.foxclub.services.SessionService;
import com.exercise.foxclub.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    private final UserService userService;
    private final FoxService foxService;
    private Logger logger;
    private SessionService sessionService;

    public LoginController(UserService userService, FoxService foxService, Logger logger, SessionService sessionService) {
        this.userService = userService;
        this.foxService = foxService;
        this.logger = logger;
        this.sessionService = sessionService;
    }

    @GetMapping("/login")
    public String renderLoginForm(Model model, Validation validation) {
        model.addAttribute("user", new User()).addAttribute("validation", validation);
        return "login/form";
    }

    @PostMapping("/login")
    public String loginUser(Model model, User user, RedirectAttributes attributes) {
        Validation validation = userService.validateAndLoginUser(user, new Validation());
        if (validation.isPasswordOK() && validation.isUsernameOK()) {
            User loggedInUser = userService.getLoggedInUser();
            model.addAttribute("user", loggedInUser);
            model.addAttribute("actionHistoryLogger", logger);
            logger.saveLoginAction();
            model.addAttribute("foxlist", loggedInUser.getFoxList());
            return "redirect:/fox/select";
        }
        model.addAttribute("user", new User());
        attributes.addFlashAttribute("validation", validation);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logut() {
        userService.logout();
        return "redirect:/login";
    }
}