package com.thymeleaf.exercise.controllers;


import com.thymeleaf.exercise.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {

    private List<BankAccount> allAccounts = new ArrayList<>();

    public BankAccountController() {
        allAccounts.add(new BankAccount("Simba", 2000, "Lion"));
        allAccounts.add(new BankAccount("Zazu", 3000, "Bird"));
        allAccounts.add(new BankAccount("Pumba", 1500, "Pig"));
        allAccounts.add(new BankAccount("Ed", 500, "Hyena"));
        allAccounts.add(new BankAccount("Musafa", 5000, "King"));
        allAccounts.add(new BankAccount("Lana", 2500, "Giraffe"));
    }

    @GetMapping("/show")
    public String showAccount(Model model) {
        BankAccount simba = new BankAccount("Simba", 2000, "Lion");
        model.addAttribute("account", simba);
        return "account";
    }

    @GetMapping("/htmlception")
    public String displayString(Model model) {
        String output = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("output", output);
        return "htmlception";
    }

    @GetMapping("/showAll")
    public String showAllAccounts(Model model) {
        model.addAttribute("accounts", allAccounts);
        return "bank-accounts";
    }

    @PostMapping("/showAll")
    public String raiseBalanceAndShowAllAccounts(Model model, @RequestParam(required = false) String name) {
        Integer increase = 10;
        if( allAccounts.stream()
                .filter(a -> a.getName().equals(name))
                .findAny()
                .get().getAnimalType() == "King")
            increase = 100;
        allAccounts.stream()
                .filter(a -> a.getName().equals(name))
                .findAny()
                .get().setBalance(
                allAccounts.stream()
                        .filter(a -> a.getName().equals(name))
                        .findAny().get().getBalance()+increase);
        model.addAttribute("accounts", allAccounts);
        return "bank-accounts";
    }
}