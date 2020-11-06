package com.greenfox.resttest.controllers;

import com.greenfox.resttest.models.Groot;
import com.greenfox.resttest.models.Rora;
import com.greenfox.resttest.services.RoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GuardianController {

    private final RoraService roraService;

    public GuardianController(RoraService roraService) {
        this.roraService = roraService;
    }


    @GetMapping("/groot")
    public ResponseEntity<Groot> getGroot(@RequestParam(required = false) String message){
        if (message == null){
            return ResponseEntity.badRequest().body(new Groot(message));
        }
        return ResponseEntity.ok().body(new Groot(message));
    }

    @GetMapping("/rocket")
    public ResponseEntity<Rora> getCargo(){
        return ResponseEntity.ok().body(new Rora());
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<Rora> getFill(@RequestParam String caliber,
                                        @RequestParam Integer amount) {

        roraService.fillCargo(caliber, amount);
        return ResponseEntity.ok().body(new Rora());
    }
}
