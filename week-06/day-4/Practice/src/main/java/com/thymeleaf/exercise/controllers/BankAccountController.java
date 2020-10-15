package com.thymeleaf.exercise.controllers;


import com.thymeleaf.exercise.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {

//    private List<BankAccount> bankAccountList = new ArrayList<>();
//
//    public BankAccountController() {
//        bankAccountList.add(new BankAccount("Joey", 1500, "cat"));
//        bankAccountList.add(new BankAccount("Simba", 2000, "lion"));
//        bankAccountList.add(new BankAccount("Meg", 3000, "zebra"));
//
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/show")
    public String showBankAccount(Model model){
        model.addAttribute("bankAccount", new BankAccount("Simba", 2000, "lion"));
        return "show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/enjoy")
    public String displayString(Model model){
        model.addAttribute("displayString", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");

        return "enjoy";
    }
}
