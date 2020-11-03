package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.Doubling;
import com.greenfox.backendapi.models.Error;
import com.greenfox.backendapi.models.Log;
import com.greenfox.backendapi.services.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoublingController {

    private final LogService logService;

    public DoublingController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/doubling")
    public Object doubling(@RequestParam(required = false) Integer input) {
        logService.save(new Log("/doubling", "input=" + input));
        if (input != null) {
            return new Doubling(input);
        } else {
            return new Error("Please provide an input!");
        }
    }
}
