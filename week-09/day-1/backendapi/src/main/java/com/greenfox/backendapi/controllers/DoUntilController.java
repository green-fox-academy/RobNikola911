package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.DoUntil;
import com.greenfox.backendapi.models.Error;
import com.greenfox.backendapi.models.Log;
import com.greenfox.backendapi.services.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoUntilController {

    private final LogService logService;

    public DoUntilController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/dountil/{action}")
    public Object doUntil(@PathVariable String action,
                          @RequestBody DoUntil doUntil) {
        logService.save(new Log("/dountil/" + action, action + ", " + doUntil.getUntil()));
        if (doUntil.getUntil() == null) {
            return ResponseEntity.badRequest().body(new Error("Please provide a number!"));
        } else
            doUntil.calculate(action);
        return ResponseEntity.ok().body(doUntil);
    }
}

