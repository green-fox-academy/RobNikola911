package com.greenfox.programmerfoxclub.models;

public enum Trick {
    HTML("write HTML"),
    JAVA("code in Java"),
    CSS("style with CSS"),
    JAVASCRIPT("use Javascript"),
    SPRING("develop with Spring");

    public final String label;

    private Trick(String label) {
        this.label = label;
    }
}