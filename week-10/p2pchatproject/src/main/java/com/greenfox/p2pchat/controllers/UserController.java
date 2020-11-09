package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.dto.UpdateRequestDTO;
import com.greenfox.p2pchat.dto.UserRequestDTO;
import com.greenfox.p2pchat.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getToRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute UserRequestDTO userRequestDTO){
        userService.registerUser(userRequestDTO);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String getToLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute UserRequestDTO userRequestDTO){
        userService.loginUser(userRequestDTO);
        return "redirect:/login";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute UpdateRequestDTO updateRequestDTO){
        userService.updateUser(updateRequestDTO);
        return "redirect:/login";
    }
}
