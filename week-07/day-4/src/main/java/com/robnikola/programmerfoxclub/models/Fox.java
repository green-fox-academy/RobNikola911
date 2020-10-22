package com.robnikola.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<Tricks> tricks;
    private String food;
    private String drink;

    public Fox(String name) {
        this.name = name;
        this.food = "Pizza";
        this.drink = "Cola";
        this.tricks = new ArrayList<>();
    }

    public Fox(String name, List<Tricks> tricks, String food, String drink) {
        this.name = name;
        if (tricks == null) {
            this.tricks = new ArrayList<>();
        }
        this.food = food;
        this.drink = drink;
        this.tricks = tricks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tricks> getTricks() {
        return tricks;
    }

    public void setTricks(List<Tricks> tricks) {
        this.tricks = tricks;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
    public void addTricks(Tricks trick){
        tricks.add(trick);
    }
}
