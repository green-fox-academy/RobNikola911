package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.Doubling;
import com.greenfox.backendapi.models.Error;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoublingController {

    @GetMapping("/doubling")
    public Object doubling(@RequestParam(required = false) Integer input) {
        if (input != null) {
            return new Doubling(input);
        } else {
            return new Error("Please provide an input!");
        }
    }
}
