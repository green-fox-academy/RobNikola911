package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    ModelMap modelMap = new ModelMap();

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Post> bestTenPost;
        if (modelMap.isEmpty()) {
            bestTenPost = postService.findBestTenPost();
        } else {
            bestTenPost = (List<Post>) modelMap.get("page");
        }
        model.addAttribute("posts", postService.findAllByOrderByLikeCounterDesc());
        model.addAttribute("posts", bestTenPost);
        return "home";
    }

    @PostMapping("/page/{pageNumber}")
    public ModelAndView changePagePost(@PathVariable("pageNumber") Integer pageNumber) throws Exception {
        modelMap.put("page", postService.showThisPage(pageNumber));
        return new ModelAndView("redirect:/", modelMap);
    }

    @GetMapping("/page/{pageNumber}")
    public ModelAndView changePageGet(@PathVariable Integer pageNumber) throws Exception {
        modelMap.put("page", postService.showThisPage(pageNumber));
        return new ModelAndView("redirect:/", modelMap);
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
