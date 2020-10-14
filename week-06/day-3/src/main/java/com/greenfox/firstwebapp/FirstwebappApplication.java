package com.greenfox.firstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class FirstwebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstwebappApplication.class, args);
    }

    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }

}
