package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.Error;
import com.greenfox.backendapi.models.SithConverter;
import com.greenfox.backendapi.services.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReverserSithController {

    private final LogService logService;

    public ReverserSithController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/sith")
    public ResponseEntity<Object> sithReverser(@RequestBody(required = false) String sentence){
        if (sentence == null) {
            return ResponseEntity.badRequest().body(new Error("Feed me some text you have to, padawan young you are. Hmmm."));
        }
        return ResponseEntity.accepted().body(new SithConverter(sentence));
    }
}
