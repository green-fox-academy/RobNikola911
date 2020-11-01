package com.greenfox.programmerfoxclub.services;

import com.greenfox.programmerfoxclub.models.Fox;
import com.greenfox.programmerfoxclub.models.Gender;

import java.util.List;

public interface FoxService {
    List<Fox> getFoxes();
    Fox getFoxByName(String name);
    void addFox(String name, Gender gender);
    boolean isFoxPresent(String name);

}