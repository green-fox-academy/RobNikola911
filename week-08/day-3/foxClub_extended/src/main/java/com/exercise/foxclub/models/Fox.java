package com.exercise.foxclub.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Fox {

    private String name;
    private Gender gender;
    private List<Trick> tricks;
    private Food food;
    private Drink drink;

    public Fox(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        tricks = new ArrayList<>();
        food = Food.PIZZA;
        drink = Drink.LEMONADE;
    }

    public List<Trick> getTricksToLearn() {
        return Arrays.stream(Trick.values())
                .filter(trick -> !getTricks().contains(trick))
                .collect(Collectors.toList());
    }

    public int getNumberTricks() {
        return tricks.size();
    }
}
