package com.greenfox.resttest.controllers;

import com.greenfox.resttest.models.Arrow;
import com.greenfox.resttest.models.Groot;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YonduController {

    @GetMapping("/yondu")
    public ResponseEntity<Arrow> getArrow(@RequestParam(required = false) Double distance,
                                          @RequestParam(required = false) Double time){

        if (distance == null || time == null){
            return ResponseEntity.badRequest().body(new Arrow(distance, time));
        }
        return ResponseEntity.ok().body(new Arrow(distance, time));
    }
}
