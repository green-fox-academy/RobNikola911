package com.exercise.foxclub.repositories;

import com.exercise.foxclub.models.Fox;
import com.exercise.foxclub.models.Gender;

import java.util.List;

public interface FoxesRepository {

    List<Fox> getAllFoxes();
    Fox getFox(String name);
    void addFox(String name, Gender gender);
}
