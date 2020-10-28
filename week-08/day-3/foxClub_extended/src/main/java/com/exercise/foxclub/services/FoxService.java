package com.exercise.foxclub.services;

import com.exercise.foxclub.models.Fox;
import com.exercise.foxclub.models.Gender;

import java.util.List;

public interface FoxService {

    List<Fox> getFoxes();
    Fox getFoxByName(String name);
    void addFox(String name, Gender gender);
    boolean isFoxPresent(String name);
}
