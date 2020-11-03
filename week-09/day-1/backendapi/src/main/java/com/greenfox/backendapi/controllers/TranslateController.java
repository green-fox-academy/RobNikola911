package com.greenfox.backendapi.controllers;

import com.greenfox.backendapi.DTOs.TranslatedTextDTO;
import com.greenfox.backendapi.models.Log;
import com.greenfox.backendapi.models.TranslatedText;
import com.greenfox.backendapi.services.LogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

    private final LogService logService;

    public TranslateController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/translate")
    public TranslatedTextDTO translate(@RequestBody(required = false) TranslatedText translatedText) {
        if (translatedText == null) {
            return new TranslatedTextDTO("I can't translate that!");
        }
        logService.save(new Log("/translate", "text="+translatedText.getText()+",lang="+translatedText.getLang().label));
        translatedText.translate();
        return new TranslatedTextDTO(translatedText);
    }
}
