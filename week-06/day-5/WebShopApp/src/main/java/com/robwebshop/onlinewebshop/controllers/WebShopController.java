package com.robwebshop.onlinewebshop.controllers;


import com.robwebshop.onlinewebshop.models.ShopItem;
import com.robwebshop.onlinewebshop.services.WebShopServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

/*    @PostMapping("webshop/search")
    public String searchItem(@ModelAttribute("text") ShopItem item) {
        webShopService.addShopItem(item);
        return "index";
    }*/

    @PostMapping("webshop/search")
    public String searchItem(Model model, @RequestParam(value = "text") String string) {
        model.addAttribute("items", webShopService.getItemByName(string));
        return "index";
    }

    @GetMapping("/webshop/more-filters")
    public String shopFilteredItems(Model model) {
        model.addAttribute("items", webShopService.getAllShopItems());
        return "filters";
    }

//    @PostMapping("webshop/more-filters")
//    public String filterByType(Model model, @RequestParam(name="text") String string) {
//        model.addAttribute("items", webShopService.getItemByType(string));
//        return "filters";
//    }

    @GetMapping("/webshop/items")
    public String filterClothes(Model model, @RequestParam Optional<String> type) {

        model.addAttribute("items", webShopService.getItemByType(type.get()));
        return "filters";
    }

/*    @GetMapping("webshop/filter-beveragesandsnacks")
    public String filterBeverages(Model model) {
        model.addAttribute("items", webShopService.getBeverages());
        return "filters";
    }*/


}
