package com.greenfox.programmerfoxclub.services;

import com.greenfox.programmerfoxclub.models.Drink;
import com.greenfox.programmerfoxclub.models.Food;
import com.greenfox.programmerfoxclub.models.Trick;

import java.util.List;

public interface ActionHistoryService {

    void foodChangeRecord(Food previous, Food current);
    void drinkChangeRecord(Drink previous, Drink current);
    void learnedTrickRecord(Trick trick);
    void loginPet(String name);
    List<String> getHistory();
    List<String> getRecentHistory();
    String getDate();

}