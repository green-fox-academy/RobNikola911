package com.greenfox.firstwebapp.controllers;

import com.greenfox.firstwebapp.models.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {

    private AtomicLong idCounter = new AtomicLong(0);

    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam String name) {
        return new Greeting( idCounter.incrementAndGet(),"Hello, " + name);
    }
}
