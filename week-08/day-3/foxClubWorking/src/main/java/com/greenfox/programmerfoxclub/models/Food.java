package com.greenfox.programmerfoxclub.models;

public enum Food {
    SALAD("salad"),
    PIZZA("pizza");

    public final String label;

    private Food(String label) {
        this.label = label;
    }
}