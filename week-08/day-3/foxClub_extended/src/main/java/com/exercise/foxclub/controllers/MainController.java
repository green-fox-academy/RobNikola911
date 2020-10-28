package com.exercise.foxclub.controllers;

import com.exercise.foxclub.models.Gender;
import com.exercise.foxclub.services.ActionHistoryService;
import com.exercise.foxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private FoxService foxService;
    private ActionHistoryService actionHistoryService;

    @Autowired
    public MainController(FoxService foxService, ActionHistoryService actionHistoryService) {
        this.foxService = foxService;
        this.actionHistoryService = actionHistoryService;
    }

    public boolean isNameParameterValid(Model model, String name) {
        if(name.equals("null")) {
            model.addAttribute("notLoggedIn", true);
            return false;
        } else if(foxService.isFoxPresent(name)) {
            return true;
        } else {
            model.addAttribute("invalidName", true);
            return false;
        }
    }

    @GetMapping("/")
    public String displayIndex(Model model, @RequestParam(value = "name", required = false) String name) {
        if(name != null) {
            if (isNameParameterValid(model, name)) {
                model.addAttribute("actionHistory", actionHistoryService.getRecentHistory());
                model.addAttribute("fox", foxService.getFoxByName(name));
                return "index";
            } else {
                return "redirect:login";
            }
        }
        return "index";
    }

    @GetMapping("/login")
    public String displayLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String registerName(Model model,
                               @ModelAttribute("name") String name,
                               @ModelAttribute("gender") Gender gender) {
        foxService.addFox(name, gender);
        actionHistoryService.loginPet(name);
        model.addAttribute("name", name);
        return "redirect:/?name="+name;
    }

}
