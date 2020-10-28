package com.exercise.foxclub.services;

import com.exercise.foxclub.models.Drink;
import com.exercise.foxclub.models.Food;
import com.exercise.foxclub.models.Trick;

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
