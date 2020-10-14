package com.greenfox.firstwebapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class FizzBuzzWoof {

    private AtomicLong numCount = new AtomicLong(0);

    @RequestMapping("/web/fizzbuzzwoof")
    public String fizzBuzzWoof(Model model) {
        long x = numCount.incrementAndGet();
        String fizzBuzzWoof = "";
        int fontSize = 18;

        if (((x % 3) == 0) && ((x % 5) == 0) && ((x % 7) == 0)) {
            fizzBuzzWoof = "FizzBuzzWoof";
            fontSize = 72;
        } else if (((x % 3) == 0) && ((x % 5) == 0)) {
            fizzBuzzWoof = "FizzBuzz";
            fontSize = 48;
        } else if ((x % 3) == 0) {
            fizzBuzzWoof = "Fizz";
            fontSize = 24;
        } else if ((x % 5) == 0) {
            fizzBuzzWoof = "Buzz";
            fontSize = 24;
        } else if ((x % 7) == 0) {
            fizzBuzzWoof = "Woof";
            fontSize = 24;
        } else {
            fizzBuzzWoof = String.valueOf(x);
        }

        model.addAttribute("fontSize", fontSize);
        model.addAttribute("numcount", fizzBuzzWoof);

        return "fizzbuzzindex";
    }

}
