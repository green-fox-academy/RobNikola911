package com.greenfox.trialexam.controllers;

import com.greenfox.trialexam.models.UrlModel;
import com.greenfox.trialexam.services.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public boolean isUrlParameterValid(Model model, String URL) {
        if(URL.equals("null")) {
            model.addAttribute("notValidURL", true);
            return false;
        } else if(urlService.isUrlPresent(URL)) {
            return true;
        } else {
            model.addAttribute("invalidName", true);
            return false;
        }
    }

    @GetMapping({"/", ""})
    public String displayMainPage(Model model, @RequestParam(value = "url", required = false) String URL) {
        if(URL != null) {
            if (isUrlParameterValid(model, URL)) {
                model.addAttribute("url", urlService.getUrlByName(URL));
                return "index";
            } else {
                return "redirect:/";
            }
        }
        return "index";
    }

    @PostMapping("/save-link")
    public String saveLink(Model model, @ModelAttribute UrlModel urlModel,
                           @RequestParam String URL,
                           @RequestParam String alias){
        urlService.createAlias(urlModel);
        model.addAttribute("URL", URL);
        model.addAttribute("alias", alias);
        return "redirect:/";
    }
}
