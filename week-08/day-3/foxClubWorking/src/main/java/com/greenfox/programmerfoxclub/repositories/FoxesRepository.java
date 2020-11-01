package com.greenfox.programmerfoxclub.repositories;

import com.greenfox.programmerfoxclub.models.Fox;
import com.greenfox.programmerfoxclub.models.Gender;

import java.util.List;

public interface FoxesRepository {
    List<Fox> getAllFoxes();
    Fox getFox(String name);
    void addFox(String name, Gender gender);

}