package com.greenfox.programmerfoxclub.controllers;

import com.greenfox.programmerfoxclub.models.*;
import com.greenfox.programmerfoxclub.services.ActionHistoryService;
import com.greenfox.programmerfoxclub.services.FoxService;
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
    public String registerName(Model model, @ModelAttribute("name") String name,
                               @ModelAttribute("gender") Gender gender) {
        foxService.addFox(name, gender);
        actionHistoryService.loginPet(name);
        model.addAttribute("name", name);
        return "redirect:/?name="+name;
    }

    @GetMapping("/nutritionStore")
    public String getNutritionStore(Model model, @RequestParam(value = "name", required = false) String name) {
        if(name != null) {
            if (isNameParameterValid(model, name)) {
                model.addAttribute("fox", foxService.getFoxByName(name));
                return "nutrition-store";
            } else {
                return "redirect:login";
            }
        }
        model.addAttribute("notLoggedIn", true);
        return "redirect:login";
    }

    @PostMapping("/nutritionStore")
    public String changeFoodAndDrinks(Model model, @RequestParam(value = "name") String name,
                                      @ModelAttribute("food") Food food,
                                      @ModelAttribute("drink") Drink drink){
        Fox fox = foxService.getFoxByName(name);
        actionHistoryService.foodChangeRecord(fox.getFood(), food);
        actionHistoryService.drinkChangeRecord(fox.getDrink(), drink);
        fox.setFood(food);
        fox.setDrink(drink);
        model.addAttribute("fox", fox);
        return "redirect:/?name="+name;
    }

    @GetMapping("/trickCenter")
    public String getTrickCenter(Model model, @RequestParam(value = "name", required = false) String name) {
        if(name != null) {
            if (isNameParameterValid(model, name)) {
                model.addAttribute("fox", foxService.getFoxByName(name));
                return "trick-center";
            } else {
                return "redirect:login";
            }
        }
        model.addAttribute("notLoggedIn", true);
        return "redirect:login";
    }

    @PostMapping("/trickCenter")
    public String addNewTricks(Model model, @RequestParam(value = "name") String name,
                               @ModelAttribute("trick") Trick trick) {
        actionHistoryService.learnedTrickRecord(trick);
        Fox fox = foxService.getFoxByName(name);
        fox.addTricks(trick);
        model.addAttribute("fox", fox);
        return "redirect:/?name="+name;
    }

    @GetMapping("/actionHistory")
    public String getActionHistory(Model model, @RequestParam(value = "name", required = false) String name) {

        model.addAttribute("name", name);
        model.addAttribute("actionHistory", actionHistoryService.getHistory());
        return "action-history";
    }
}
