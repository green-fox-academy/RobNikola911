package com.robnikola.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<Trick> tricks;
    private Food food;
    private Drink drink;

    public Fox(String name) {
        this.name = name;
        this.food = Food.SALAD;
        this.drink = Drink.WATER;
        this.tricks = new ArrayList<>();
//        tricks.add(Trick.CSS);
    }

    public Fox(String name, List<Trick> tricks, Food food, Drink drink) {
        this.name = name;
        if (tricks == null) {
            this.tricks = new ArrayList<>();
        } else {
            this.tricks = tricks;
        }
        this.food = food;
        this.drink = drink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trick> getTricks() {
        return tricks;
    }

    public void setTricks(List<Trick> tricks) {
        this.tricks = tricks;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void addTrick(Trick trick) {
        if (tricks.contains(trick))
            return;
        tricks.add(trick);
    }
}
