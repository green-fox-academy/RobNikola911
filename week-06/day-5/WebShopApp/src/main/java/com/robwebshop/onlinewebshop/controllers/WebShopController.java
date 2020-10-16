package com.robwebshop.onlinewebshop.controllers;


import com.robwebshop.onlinewebshop.services.WebShopServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebShopController {

    private WebShopServiceImpl webShopService = new WebShopServiceImpl();

    @GetMapping("/webshop")
    public String shopItem(Model model) {
        model.addAttribute("items", webShopService.getAllShopItems());
        return "index";
    }

    @GetMapping("/webshop/only-available")
    public String onlyAvailable(Model model) {
        model.addAttribute("items", webShopService.getShopItemAvailable());
        return "index";
    }

    @GetMapping("/webshop/cheapest-first")
    public String cheapestFirst(Model model) {
        model.addAttribute("items", webShopService.getCheapestFirst());
        return "index";
    }

    @GetMapping("webshop/contains-nike")
    public String containsNike(Model model) {
        model.addAttribute("items", webShopService.getNike("Nike"));
        return "index";
    }

    @GetMapping("webshop/average-stock")
    public String averageStock(Model model) {
        model.addAttribute("items", webShopService.getAverageStock());
        return "averageStock";
    }

    @GetMapping("webshop/most-expensive")
    public String mostExpensive(Model model) {
        model.addAttribute("items", webShopService.getMostExpensive());
        return "index";
    }

}
