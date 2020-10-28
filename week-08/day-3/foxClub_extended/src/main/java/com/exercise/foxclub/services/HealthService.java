package com.exercise.foxclub.services;

import com.exercise.foxclub.models.character.Fox;

public interface HealthService {
    void healTotally(Fox fox);

    boolean heal(Fox fox);

    void harm(Fox fox, int damage);
}
