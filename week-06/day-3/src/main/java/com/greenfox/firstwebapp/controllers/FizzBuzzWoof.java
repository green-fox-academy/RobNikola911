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

        if (((x % 3) == 0) && ((x % 5) == 0) && ((x % 7) == 0)) {
            fizzBuzzWoof = "FizzBuzzWoof";
        } else if (((x % 3) == 0) && ((x % 5) == 0)) {
            fizzBuzzWoof = "FizzBuzz";
        } else if ((x % 3) == 0) {
            fizzBuzzWoof = "Fizz";
        } else if ((x % 5) == 0) {
            fizzBuzzWoof = "Buzz";
        } else if ((x % 7) == 0) {
            fizzBuzzWoof = "Woof";
        } else {
            fizzBuzzWoof = String.valueOf(x);
        }

        model.addAttribute("numcount", fizzBuzzWoof);

        return "fizzbuzzindex";
    }

}
