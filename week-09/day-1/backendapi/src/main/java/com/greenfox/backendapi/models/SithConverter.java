package com.greenfox.backendapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SithConverter {

    @JsonProperty("sith_text")
    private String sithText;

    public SithConverter(String text) {
        this.sithText = convertToSith(text);
    }

    private String convertToSith(String text) {

        Random rand = new Random();

        sithText = "";
        for (String sentence: text.split("\\. ")) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i+=2) {
                if(i+1 < words.length) {
                    if (i == 0) {
                        sithText += capitalize(words[i+1]) + " " + words[i].toLowerCase();
                    } else {
                        sithText += " " + words[i+1] + " " + words[i];
                    }
                } else if (i < words.length) {
                    sithText += " " + words[i];
                }
            }
            sithText += ". ";
            for (int i = -1; i < rand.nextInt(2); i++) {
                sithText += YodaThing.randomThing().label + " ";
            }
        }

        return sithText;
    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}