package com.robnikola.programmerfoxclub.services;

import com.robnikola.programmerfoxclub.models.Drink;
import com.robnikola.programmerfoxclub.models.Food;
import com.robnikola.programmerfoxclub.models.Fox;
import com.robnikola.programmerfoxclub.models.Trick;

import java.util.List;

public interface FoxService {
    Fox getFoxByName(String name);
    List<Fox> getAllFoxes();
    boolean checkFox(String name);
    void setFood(String name, Food food);
    void setDrink(String name, Drink drink);
    void setTrick(String name, Trick trick);
    List<Trick> getPossibleTricksToLearn(String name);
    boolean learnedAll(String name);
}
