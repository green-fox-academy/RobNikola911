package com.greenfox.backendapi.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.greenfox.backendapi.models.Language;
import com.greenfox.backendapi.models.TranslatedText;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TranslatedTextDTO {

    private String translated;
    private Language lang;
    private String error;

    public TranslatedTextDTO() {
    }

    public TranslatedTextDTO(TranslatedText translatedText) {
        this.translated = translatedText.getTranslated();
        this.lang = translatedText.getLang();
        this.error = translatedText.getError();
    }

    public TranslatedTextDTO(String error) {
        this.error = error;
    }
}