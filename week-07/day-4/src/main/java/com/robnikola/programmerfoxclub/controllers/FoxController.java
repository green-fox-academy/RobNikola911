package com.robnikola.programmerfoxclub.controllers;

import com.robnikola.programmerfoxclub.models.Drink;
import com.robnikola.programmerfoxclub.models.Food;
import com.robnikola.programmerfoxclub.models.Fox;
import com.robnikola.programmerfoxclub.models.Trick;
import com.robnikola.programmerfoxclub.repositories.FoxRepository;
import com.robnikola.programmerfoxclub.services.FoxService;
import com.robnikola.programmerfoxclub.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

    private LoginService loginService;
    private FoxService foxService;
    private FoxRepository foxRepository;

    @Autowired
    public FoxController(LoginService loginService, FoxService foxService, FoxRepository foxRepository) {
        this.loginService = loginService;
        this.foxService = foxService;
        this.foxRepository = foxRepository;
    }

    @ModelAttribute
    public void addFoodDrinkAndTrickList(Model model) {
        model.addAttribute("foodList", Food.values());
        model.addAttribute("drinkList", Drink.values());
        model.addAttribute("trickList", Trick.values());
    }

    @GetMapping("/nutrition-store")
    public String getNutritionStore(@RequestParam (required = false) String name, Model model){
        model.addAttribute("fox", loginService.getFox(name));
        return "nutrition-store";
    }

    @PostMapping("/nutrition-store")
    public String postNutritionStore(@RequestParam (required = false) String name, Model model) {
//        Fox fox = loginService.getFox(name);
        model.addAttribute("fox", loginService.getFox(name));
        return "redirect:/";
    }


}
