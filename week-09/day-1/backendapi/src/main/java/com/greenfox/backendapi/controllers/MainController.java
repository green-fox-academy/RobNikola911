package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.Doubling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

//    @ResponseBody
//    @GetMapping("/doubling")
//    public Doubling doubling(@RequestParam Integer input){
//
//        return new Doubling(input);
//    }
}
