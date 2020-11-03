package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.models.Array;
import com.greenfox.backendapi.models.Error;
import com.greenfox.backendapi.models.Log;
import com.greenfox.backendapi.services.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ArrayController {

    private final LogService logService;

    public ArrayController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/arrays")
    public Object handleArray(@RequestBody Array array) {
        logService.save(new Log("/arrays", array.getWhat() + "," + Arrays.toString(array.getNumbers())));
        if (array.getWhat() == null || array.getNumbers() == null) {
            return ResponseEntity.badRequest().body(new Error("Please provide a number!"));
        }
        switch (array.getWhat()) {
            case "sum":
                array.sumArray(array);
                ResponseEntity.ok().body(array);
                break;
            case "multiply":
                array.multiplyArray(array);
                ResponseEntity.ok().body(array);
                break;
            case "double":
                array.doubleArray(array);
                ResponseEntity.ok().body(array);
                break;
            default:
                ResponseEntity.badRequest().body(new Error("Please provide a number!"));
        }
        return array;

        /*if (array.getWhat() == null && array.getNumbers() == null) {
            return ResponseEntity.badRequest().body(new Error("Please provide a number!"));
        } else if (array.getWhat().equals("sum")) {
            array.sumArray(array);
            return ResponseEntity.ok().body(array);
        } else if (array.getWhat().equals("multiply")) {
            array.multiplyArray(array);
            return ResponseEntity.ok().body(array);
        } else if (array.getWhat().equals("double")) {
            array.doubleArray(array);
            return ResponseEntity.ok().body(array);
        }
        return ResponseEntity.badRequest().body(new Error("Please provide a number!"));*/
    }
}

