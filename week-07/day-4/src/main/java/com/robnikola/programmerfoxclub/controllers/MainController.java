package com.robnikola.programmerfoxclub.controllers;

import com.robnikola.programmerfoxclub.services.FoxService;
import com.robnikola.programmerfoxclub.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private LoginService loginService;
    private FoxService foxService;

    @Autowired
    public MainController(LoginService loginService, FoxService foxService) {
        this.loginService = loginService;
        this.foxService = foxService;
    }

    @GetMapping("/")
    public String home(@RequestParam (required = false) String name, Model model){
        if (name == null){
            return "index";
        }
        if (!foxService.checkFox(name)){
            return "redirect:/login";
        }
        model.addAttribute("fox", loginService.getFox(name));
        return "index";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String name){
        loginService.addFox(name);
        return "redirect:/?name="+name;
    }
}
