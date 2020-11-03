package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.services.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public Object getLogs(){
        return ResponseEntity.ok().body(logService.logEntries());
    }
}

