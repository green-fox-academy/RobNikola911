package com.exercise.foxclub.repositories;

import com.exercise.foxclub.models.nutrition.Drink;
import com.exercise.foxclub.models.nutrition.Food;
import com.exercise.foxclub.models.nutrition.Nutrition;
import org.springframework.data.repository.CrudRepository;

public interface NutritionRepository extends CrudRepository<Nutrition, Long> {
    boolean findByNameIsNotLike(String name);
    Drink findDrinkById(long id);
    Food findFoodById(long id);
    Food findFoodByName(String name);
    Drink findDrinkByName(String name);
    Nutrition findByName(String name);
}