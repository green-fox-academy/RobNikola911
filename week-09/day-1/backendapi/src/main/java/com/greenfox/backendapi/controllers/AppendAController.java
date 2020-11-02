package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.AppendA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppendAController {

    @GetMapping("/appenda/{appendable}")
    public Object append(@PathVariable String appendable) {
        if (appendable != null) {
            AppendA append = new AppendA(appendable.concat("a"));
        return ResponseEntity.ok().body(append);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
