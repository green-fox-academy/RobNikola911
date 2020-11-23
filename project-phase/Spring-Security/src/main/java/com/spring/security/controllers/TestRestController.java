package com.spring.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/testEndpoint")
    public String test() {
        return "GreenFox";
    }

    @GetMapping("/testSecuredEndpoint")
    public String testSecured() {
        return "Secured GreenFox";
    }
}
