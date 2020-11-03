package com.greenfox.backendapi.models;

import lombok.Getter;

import java.util.stream.Collectors;

@Getter
public class TranslatedText {

    private String text;
    private Language lang;
    private String translated;
    private String error;

    public void translate() {
        if (text == null || lang == null) {
            error = "I can't translate that!";
            return;
        }
        translated = "";
        for (String word: text.split(" ")) {
            translated += translateWord(word) + " ";
        }
    }

    private String translateWord(String word) {
        return word.codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .map(c -> ("aáeéiou".contains(c)) ? c + 'v' + c : c)
                .collect(Collectors.joining(""));
    }

}