package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.Error;
import com.greenfox.backendapi.models.Greeter;
import com.greenfox.backendapi.models.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {

    @GetMapping("/greeter")
    public Object greeting(@RequestParam(required = false) String name,
                           @RequestParam(required = false) String title) {
        Greeter greeter = new Greeter(name, title);

        if (name != null && title != null) {
            return ResponseEntity.ok().body(new Message("Oh, hi there " + greeter.getName() + ", my dear " + greeter.getTitle() + "!"));
        } else if (name == null && title != null) {
            return ResponseEntity.badRequest().body(new Error("Please provide a name!"));
        } else if (name != null) {
            return ResponseEntity.badRequest().body(new Error("Please provide a title!"));
        } else {
            return ResponseEntity.badRequest().body(new Error ("Please provide a name and a title!"));
        }
    }
}
