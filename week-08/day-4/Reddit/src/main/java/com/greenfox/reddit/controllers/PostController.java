package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.pageablePostByLikeCounter(0));
        model.addAttribute("currentPage", 0);
        return "home";
    }

    @GetMapping("/{currentPage}")
    public String currentPage(Model model, @PathVariable(name = "currentPage") int currentPage) {
        int nextPage = postService.validPage(currentPage);
        if (nextPage != currentPage) {
            return "redirect:/" + nextPage;
        }
        model.addAttribute("posts", postService.pageablePostByLikeCounter(currentPage));
        return "home";
    }

    @GetMapping("/submit")
    public String submit(){
        return "submit";
    }

    @PostMapping("/submit")
    public String submitPost(@ModelAttribute Post post){
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

    @GetMapping("/{id}/update")
    public String updateCounter (@PathVariable Long id, @RequestParam int likeChange){
        postService.updateLikeCounter(id, likeChange);
        return "redirect:/";
    }
}
