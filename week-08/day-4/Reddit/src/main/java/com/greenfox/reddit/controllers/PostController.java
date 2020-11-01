package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.models.User;
import com.greenfox.reddit.services.PostService;
import com.greenfox.reddit.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.pageablePostByLikeCounter(0));
        model.addAttribute("currentPage", 0);
        model.addAttribute("pages", postService.maxPage());
        return "home";
    }

    @GetMapping("/{currentPage}")
    public String currentPage(Model model, @PathVariable(name = "currentPage") int currentPage) {
        int nextPage = postService.validPage(currentPage);
        if (nextPage != currentPage) {
            return "redirect:/" + nextPage;
        }
        model.addAttribute("posts", postService.pageablePostByLikeCounter(currentPage));
        model.addAttribute("pages", postService.maxPage());
        return "home";
    }

    @GetMapping("/submit")
    public String submit() {
        return "submit";
    }

    @PostMapping("/submit")
    public String submitPost(@ModelAttribute Post post) {
        postService.submitPost(post);
        return "redirect:/";
    }

//    @GetMapping("/{id}/increment")
//    public String increment(@PathVariable Long id){
//        postService.increment(id);
//        return "redirect:/";
//    }
//
//    @GetMapping("/{id}/decrement")
//    public String decrement(@PathVariable Long id){
//        postService.decrement(id);
//        return "redirect:/";
//    }

    @GetMapping("/{id}/{currentPage}/update")
    public String updateCounter(@PathVariable Long id, @PathVariable int currentPage,
                                @RequestParam int likeChange) {
        postService.updateLikeCounter(id, likeChange);
        return "redirect:/" + currentPage;
    }

    @GetMapping("/login")
    public String loginUser() {

        return "loginPage";
    }

    @PostMapping("/login")
    public String loginUser(String username, String password) {
        List<User> listOfUsers = userService.findAllUsers();
        if (userService.checkUser(username, password)) {
            return "redirect:/";
        } else {
            return "wrongUser";
        }
    }

    @GetMapping("/register")
    public String registerUser(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
}
