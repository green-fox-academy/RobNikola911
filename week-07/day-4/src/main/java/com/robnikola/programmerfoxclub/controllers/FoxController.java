package com.robnikola.programmerfoxclub.controllers;

import com.robnikola.programmerfoxclub.models.Drink;
import com.robnikola.programmerfoxclub.models.Food;
import com.robnikola.programmerfoxclub.models.Trick;
import com.robnikola.programmerfoxclub.repositories.FoxRepository;
import com.robnikola.programmerfoxclub.services.FoxService;
import com.robnikola.programmerfoxclub.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public FoxController(LoginService loginService, FoxService foxService, FoxRepository foxRepository) {
        this.loginService = loginService;
        this.foxService = foxService;
    }

    @ModelAttribute
    public void addFoodDrinkAndTrickList(Model model) {
        model.addAttribute("foodList", Food.values());
        model.addAttribute("drinkList", Drink.values());
    }

    @GetMapping("/nutritionStore")
    public String getNutritionStore(@RequestParam String name, Model model){
        model.addAttribute("fox", loginService.getFox(name));
        model.addAttribute("name", name);
        return "nutrition-store";
    }

    @PostMapping("/nutritionStore")
    public String postNutritionStore(@RequestParam Drink drink, @RequestParam Food food,
                                     @RequestParam String name) {
        foxService.setFood(name, food);
        foxService.setDrink(name, drink);

        return "redirect:/?name="+name;
    }

    @GetMapping("/trickCenter")
    public String getTrickCenter(@RequestParam String name, Model model){
        model.addAttribute("fox", loginService.getFox(name));
        model.addAttribute("name", name);
        model.addAttribute("trickList", foxService.getPossibleTricksToLearn(name));
        model.addAttribute("learned", foxService.learnedAll(name));
        return "trick-center";
    }

    @PostMapping("/trickCenter")
    public String postTrickCenter(@RequestParam Trick trick, @RequestParam String name) {
        foxService.setTrick(name, trick);
        return "redirect:/?name="+name;
    }

    @GetMapping("/actionHistory")
    public String getActionHistory(@RequestParam String name, Model model){
        model.addAttribute("fox", loginService.getFox(name));
        model.addAttribute("name", name);
        return "index";
    }

}
