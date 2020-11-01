package com.greenfox.programmerfoxclub.models;

public enum Gender {
    HE("he"),
    SHE("she"),
    THEY("they");

    public final String label;

    private Gender(String label) {
        this.label = label;
    }
}