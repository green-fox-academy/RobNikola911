package com.exercise.webapp.controllers;

import com.exercise.webapp.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilityController {

    private final UtilityService utilityService;

    @Autowired
    public UtilityController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("/useful")
    public String usefulLinks(Model model){
        model.addAttribute("random", utilityService.randomColor());
        model.addAttribute("caesar", utilityService.caesar("abc", 10));
        return "index";
    }

    @GetMapping("/useful/colored")
    public String usefulColored(Model model){
        model.addAttribute("random", utilityService.randomColor());
        return "colored";
    }

    @GetMapping("/useful/email")
    public String usefulEmail(Model model, @RequestParam(value = "email", required = false) String email){
        model.addAttribute("email", utilityService.validateEmail(email));
        return "email";
    }

    @GetMapping("/useful/encoder")
    public String ceasarEncoder(Model model, @RequestParam String text,
                                            @RequestParam int number){
        String encoded = utilityService.caesar(text, number);
        model.addAttribute("text", text);
        model.addAttribute("result", encoded);
        return "encoder";
    }

    @GetMapping("/useful/decoder")
    public String ceasarDecoder(Model model, @RequestParam String text,
                                             @RequestParam int number){
        String decoded = utilityService.caesar(text, -number);
        model.addAttribute("text", text);
        model.addAttribute("result", decoded);
        return "decoder";
    }


// ## Caesar encoder/decoder
// - Caesar coding is just shifting every character in the text with a specific number of amount
// in the alphabet, coded `example` with `1` is `fybnqmf`._
// - Have two endpoints (one for encoding and one for decoding) with a `text` and `number` query param
// - Have a link at the main page for both
// - For encoding use the `number` value, for decoding use the `-number` value when calling the
// caesar() method.
//     - As a rule of usage: you cannot give negative value for the 'number' query param
}
