package com.exercise.foxclub.services;

import com.exercise.foxclub.models.character.Fox;
import com.exercise.foxclub.models.nutrition.Nutrition;

public interface NutritionService {
    void reduceNutritionLevel(Fox fox);

    void checkLevels(Fox fox, Nutrition nutrition);

    void increaseThirstLevel(Fox fox);

    void increaseHungerLevel(Fox fox);

    void reduceFoxHealth(Fox fox);

    void feed(Fox fox, Nutrition nutrition);

    void saveNutritionIfNotExists(Nutrition nutrition);

    void saveNutrition(String nutritionName);
}