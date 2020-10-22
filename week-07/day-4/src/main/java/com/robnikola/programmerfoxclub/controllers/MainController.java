package com.robnikola.programmerfoxclub.controllers;

import com.robnikola.programmerfoxclub.services.LoginService;
import com.robnikola.programmerfoxclub.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private LoginService loginService;

    public MainController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String name){
        loginService.addFox(name);
        return "redirect:index";
    }
}
