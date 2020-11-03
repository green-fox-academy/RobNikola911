package com.greenfox.backendapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Language {
    @JsonProperty("hu")
    HUNGARIAN("hu"),
    @JsonProperty("en")
    ENGLISH("en");

    public final String label;

    private Language(String label) {
        this.label = label;
    }
}