package com.exercise.foxclub.services;

import com.exercise.foxclub.models.character.Fox;
import com.exercise.foxclub.repositories.NutritionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImp implements SessionService {
    private Logger logger;
    private NutritionService nutritionService;
    private FoxService foxService;
    private UserService userService;
    private NutritionRepository nutritionRepository;

    public SessionServiceImp(Logger logger, NutritionService nutritionService, FoxService foxService, UserService userService, NutritionRepository nutritionRepository) {
        this.logger = logger;
        this.nutritionService = nutritionService;
        this.foxService = foxService;
        this.userService = userService;
        this.nutritionRepository = nutritionRepository;
    }

    public void updateFoxAndNutrition() {
        List<Fox> foxList = foxService.findAll();
        for (Fox fox : foxList) {
            if (fox.isAlive()) {
                nutritionService.reduceNutritionLevel(fox);
                foxService.update(fox);
            }
        }
    }
}