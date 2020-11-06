package com.greenfox.resttest.models;

public enum Shipstatus {
    EMPTY("empty"),
    FORTY("40%"),
    FULL("full"),
    OVERLOADED("overloaded");


    public final String label;

    private Shipstatus(String label) {
        this.label = label;
    }
}
