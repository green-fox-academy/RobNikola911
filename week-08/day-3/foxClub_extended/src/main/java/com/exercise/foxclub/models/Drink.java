package com.exercise.foxclub.models;

public enum Drink {
    WATER("water"),
    LEMONADE("lemonade");

    public final String label;

    private Drink(String label) {
        this.label = label;
    }
}
