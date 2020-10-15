package com.thymeleaf.exercise.controllers;


import com.thymeleaf.exercise.models.BankAccount;
import com.thymeleaf.exercise.models.GoodBad;
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

    @RequestMapping(method = RequestMethod.GET, path = "/show")
    public String showBankAccount(Model model) {
        model.addAttribute("bankAccount", new BankAccount("Simba", 2000, "lion"));
        return "show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/enjoy")
    public String displayString(Model model) {
        model.addAttribute("displayString", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "enjoy";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accountlist")
    public String accountList(Model model) {

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("Nala", 1500, "lion"));
        accounts.add(new BankAccount("Timon", 2500, "meerkat"));
        accounts.add(new BankAccount("Pumba", 1000, "pig"));
        accounts.add(new BankAccount("Scar", 3000, "lion"));
        accounts.add(new BankAccount("Mufasa", 4500, "lion"));

        model.addAttribute("accountList", accounts);

        return "accountlist";
    }
}
