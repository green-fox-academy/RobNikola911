package com.greenfox.p2pchat.controllers;

import com.greenfox.p2pchat.dto.CreateChannelDTO;
import com.greenfox.p2pchat.dto.UpdateRequestDTO;
import com.greenfox.p2pchat.dto.UserRequestDTO;
import com.greenfox.p2pchat.models.Message;
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
        model.addAttribute("messages",
                userService.getMessages(model.getAttribute("apiKey").toString(), 5));
        return "index";
    }


    @GetMapping("/register")
    public String getToRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost( @ModelAttribute UserRequestDTO userRequestDTO,
                               RedirectAttributes attributes){
        Object user = userService.registerUser(userRequestDTO);

        if(user != null) {
            attributes.addFlashAttribute("registrationSuccess", true);
            return "redirect:/login";
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

        Object user = userService.loginUser(userRequestDTO);
        if (user == null) {
            attributes.addFlashAttribute("loginFailed", true);
            return "redirect:/login";
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

    @PostMapping("/postMessage")
    public String postMessage(Model model, @RequestParam String message,
                              RedirectAttributes attributes) {
        Message messageObj = userService.postMessage(model.getAttribute("apiKey").toString(), message);
        attributes.addFlashAttribute("username", messageObj.getAuthor().getUsername());
        attributes.addFlashAttribute("userAvatar", messageObj.getAuthor().getAvatarUrl());
        return "redirect:/";

    }

    @GetMapping("/createChannel")
    public String getChannel(Model model) {
        if (model.getAttribute("apiKey") == null) {
            return "login";
        }
        return "channel";
    }

    @PostMapping("/createChannel")
    public String createChannel(Model model, @ModelAttribute CreateChannelDTO createChannelDTO,
                                RedirectAttributes attributes) {
        userService.createChannel(createChannelDTO, model.getAttribute("apiKey").toString());
        attributes.addFlashAttribute("channelname", createChannelDTO.getName());
        attributes.addFlashAttribute("createSuccess", true);
        return "redirect:/user-channels";

    }

    @GetMapping("/user-channels")
    public String getMyChannels(Model model) {
        if (model.getAttribute("apiKey") == null) {
            return "login";
        }
        model.addAttribute("channels",
                userService.getChannels(model.getAttribute("apiKey").toString()));
        return "channel";
    }

}
