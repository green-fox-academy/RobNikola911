package com.greenfox.trialexam.controllers;

import com.greenfox.trialexam.models.UrlModel;
import com.greenfox.trialexam.services.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final UrlService urlService;

    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping({"/", ""})
    public String displayMainPage() {
        return "index";
    }

    @PostMapping("/save-link")
    public String saveLink(@ModelAttribute UrlModel urlModel, @RequestParam String URL){
        urlService.createAlias(urlModel);
        return "redirect:/";
    }
}
