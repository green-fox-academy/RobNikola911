package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.dto.UpdateRequestDTO;
import com.greenfox.p2pchat.dto.UserRequestDTO;
import com.greenfox.p2pchat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("apiKey")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public String redirectToLogin(Model model) {
        if (model.getAttribute("apiKey") == null) {
            return "redirect:/login";
        }
        model.addAttribute("messages", userService.getMessages(model.getAttribute("apiKey").toString(), 20));
        return "index";
    }


    @GetMapping("/register")
    public String getToRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(Model model, @ModelAttribute UserRequestDTO userRequestDTO,
                               RedirectAttributes attributes){
        userService.registerUser(userRequestDTO);

        if(userService.registerUser(userRequestDTO) != null) {
            attributes.addFlashAttribute("registrationSuccess", true);
            return "login";
        }
        attributes.addFlashAttribute("registrationFail", true);
        return "register";
    }

    @GetMapping("/login")
    public String getToLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(Model model, @ModelAttribute UserRequestDTO userRequestDTO,
                            RedirectAttributes attributes){

        if (userService.loginUser(userRequestDTO) == null) {
            attributes.addFlashAttribute("loginFailed", true);
            return "login";
        }

        model.addAttribute("apiKey", userService.loginUser(userRequestDTO));
        attributes.addFlashAttribute("username", userRequestDTO.getLogin());
        attributes.addFlashAttribute("loginSuccess", true);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String getUpdate(Model model) {
        if (model.getAttribute("apiKey") == null) {
            return "login";
        }
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(Model model, @ModelAttribute UpdateRequestDTO updateRequestDTO,
                             RedirectAttributes attributes){

        userService.updateUser(updateRequestDTO, model.getAttribute("apiKey").toString());
        attributes.addFlashAttribute("username", updateRequestDTO.getUsername());
        attributes.addFlashAttribute("userAvatar", updateRequestDTO.getAvatarUrl());
        attributes.addFlashAttribute("updateSuccess", true);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutPost(Model model, SessionStatus status, RedirectAttributes attributes){
        Boolean success = userService.logoutUser(model.getAttribute("apiKey").toString());
        if (success) {
            attributes.addFlashAttribute("logoutSuccess", true);
        }
        status.setComplete();
        return "redirect:/login";
    }
}
