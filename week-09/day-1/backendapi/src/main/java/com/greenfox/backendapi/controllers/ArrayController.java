package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.Array;
import com.greenfox.backendapi.models.ArrayResultType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrayController {

    @PostMapping("/arrays")
    public Object handleArray(@RequestBody Array array) {

        if (array.getWhat().equals("sum")) {
            array.sumArray(array);
            return ResponseEntity.ok().body(array);
        } else if (array.getWhat().equals("multiply")) {
            array.multiplyArray(array);
            return ResponseEntity.ok().body(array);
        } else if (array.getWhat().equals("double")) {
            array.doubleArray(array);
            return ResponseEntity.ok().body(array);
        } else
            return new Error("Please provide what to do with the numbers!");
    }
}

